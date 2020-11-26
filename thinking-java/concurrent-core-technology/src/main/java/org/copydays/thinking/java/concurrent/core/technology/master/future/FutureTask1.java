package org.copydays.thinking.java.concurrent.core.technology.master.future;

import java.util.Random;
import java.util.concurrent.*;

public class FutureTask1 {
    public static void main(String[] args) {

        // 第一种方式
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt();
            }
        });

        new Thread(task).start();

        // 第二种方方式
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        FutureTask<Integer> task2 = new FutureTask<Integer>(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                return new Random().nextInt();
//            }
//        });
//        executor.submit(task2);
//        executor.shutdown();

        try {
            System.out.println("result: " + task.get());
//            System.out.println("result: " + task2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}