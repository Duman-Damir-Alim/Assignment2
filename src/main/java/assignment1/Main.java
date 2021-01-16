package assignment1;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Pattern;

public class Main {

    public static final File DIRECTORY = new File("/Users/rakhad/Documents/assignment_files");

    private static final int THREAD_NUM = 4;

    private static final ArrayList<File> modify_files = files_for_modifying();

    private static final ArrayList<File> revert_files = files_for_reverting();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);
        Future<ArrayList<File>> future = executorService.submit(new MyCallable(DIRECTORY));
        for (File file: future.get()){
            System.out.println(file.getName());
        }

        System.out.println("1 - revert, 2 - rename");
        Scanner scanner = new Scanner(System.in);
        int response = scanner.nextInt();
        if (response == 2){
            for (int i = 0; i < THREAD_NUM; ++i){
                if (modify_files.size() > i){
                    executorService.submit(new Modifier(modify_files, i, THREAD_NUM));
                }
            }
        }else{
            for (int i = 0; i < THREAD_NUM; ++i){
                if (revert_files.size() > i){
                    executorService.submit(new Returner(revert_files, i, THREAD_NUM));
                }
            }
        }
        executorService.shutdown();


        BlockingQueue queue = new BlockingQueue();

        Thread worker = new Thread(() -> {
            do {
                queue.get().run();
            } while (!queue.tasks.isEmpty());
        });
        worker.start();

        for (int q = 1; q <= 3; ++q){
            int finalQ = q;
            queue.put(() -> {
                System.out.println(finalQ + " thread is running:");
                for (int i = 0; i < 10; i++){
                    System.out.println(i);
                }
                System.out.println(finalQ + " thread is finished");
                System.out.println("=======");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    static ArrayList<File> files_for_reverting(){
        ArrayList<File> files = new ArrayList<>();
        for (File file: Objects.requireNonNull(DIRECTORY.listFiles())){
            String fileName = file.getName();
            if (Pattern.matches("\\b[0-9]*$\\b", fileName.split("\\.")[0])){
                files.add(file);
            }
        }
        return files;
    }

    static ArrayList<File> files_for_modifying(){
        ArrayList<File> files = new ArrayList<>();
        for (File file: Objects.requireNonNull(DIRECTORY.listFiles())){
            String fileName = file.getName();
            if (Pattern.matches("\\bfile_[0-9]*$\\b", fileName.split("\\.")[0])){
                files.add(file);
            }
        }
        return files;
    }

}