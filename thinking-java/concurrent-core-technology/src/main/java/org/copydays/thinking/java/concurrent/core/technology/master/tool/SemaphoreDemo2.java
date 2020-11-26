package org.copydays.thinking.java.concurrent.core.technology.master.tool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo2 {

    private final static int threadCount = 20;

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();  // 使用线程池

        final Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;

            exec.execute(() -> {
                try {
                    semaphore.acquire(2); // 获取全部许可，退化成串行执行，使用 permits 调整权重

                    test(threadNum);

                    semaphore.release(2); // 释放多个许可
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        System.out.println("id:" + threadNum + "," + Thread.currentThread().getName());
        Thread.sleep(1000);
    }
}
