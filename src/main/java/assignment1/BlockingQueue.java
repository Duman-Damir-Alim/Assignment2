package assignment1;

import java.util.ArrayList;

public class BlockingQueue {
    ArrayList<Runnable> tasks = new ArrayList<>();

    synchronized Runnable get() {
        while (tasks.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Runnable task = tasks.get(0);
        tasks.remove(task);
        return task;
    }

    synchronized void put(Runnable task){
        tasks.add(task);
        notify();
    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();

        Thread worker = new Thread(() -> {
            do {
                blockingQueue.get().run();
            } while (!blockingQueue.tasks.isEmpty());
        });
        worker.start();

        for (int q = 1; q <= 3; ++q){
            int finalQ = q;
            blockingQueue.put(() -> {
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
}
