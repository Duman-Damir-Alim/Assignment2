package assignment1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.regex.Pattern;

@WebServlet(name = "DemoServlet")
public class DemoServlet extends HttpServlet {
    public ArrayBlockingQueue<String> blockingQueueFileNames = new ArrayBlockingQueue<>(110);
    public final int THREAD_NUM = 4;

    public String PATH = "/Users/rakhad/Documents/assignment_files";

    private final ArrayList<File> modify_files = files_for_modifying();

    private final ArrayList<File> revert_files = files_for_reverting();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

        switch (action){
            case "clear":
                for (String fileName: blockingQueueFileNames){
                    blockingQueueFileNames.remove(fileName);
                }
                request.setAttribute("files", blockingQueueFileNames);
                request.getRequestDispatcher("./jsp/demo.jsp").forward(request, response);
                break;
            case "rename":
                for (int i = 0; i < THREAD_NUM; ++i){
                    if (modify_files.size() > i){
                        executorService.submit(new Modifier(modify_files, i, THREAD_NUM));
                    }
                }
                executorService.submit(() -> {
                    try {
                        System.out.println("Finished");
                        request.getRequestDispatcher("./jsp/demo.jsp").forward(request, response);
                    } catch (ServletException | IOException e) {
                        e.printStackTrace();
                    }
                });
                executorService.shutdown();
                break;
            case "revert":
                for (int i = 0; i < THREAD_NUM; ++i){
                    if (revert_files.size() > i){
                        executorService.submit(new Returner(revert_files, i, THREAD_NUM));
                    }
                }
                request.getRequestDispatcher("./jsp/demo.jsp").forward(request, response);
                executorService.shutdown();
                break;
            case "load":
                String path = request.getParameter("path");
                if (!path.isEmpty()){
                    PATH = path;
                }
                doGet(request, response);
                break;
            default:
                doGet(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);
        Future<ArrayList<File>> future = executorService.submit(new MyCallable(new File(PATH)));
        try {
            ArrayList<String> files = new ArrayList<>();
            blockingQueueFileNames.clear();
            for (File file: future.get()){
                files.add(file.getName());
                blockingQueueFileNames.add(file.getName());
            }
            request.setAttribute("files", files);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        request.getRequestDispatcher("./jsp/demo.jsp").forward(request, response);
    }

    private ArrayList<File> files_for_reverting(){
        ArrayList<File> files = new ArrayList<>();
        for (File file: Objects.requireNonNull(new File(PATH).listFiles())){
            String fileName = file.getName();
            if (Pattern.matches("\\b[0-9]*$\\b", fileName.split("\\.")[0])){
                files.add(file);
            }
        }
        return files;
    }

    private ArrayList<File> files_for_modifying(){
        ArrayList<File> files = new ArrayList<>();
        for (File file: Objects.requireNonNull(new File(PATH).listFiles())){
            String fileName = file.getName();
            if (Pattern.matches("\\bfile_[0-9]*$\\b", fileName.split("\\.")[0])){
                files.add(file);
            }
        }
        return files;
    }
}
