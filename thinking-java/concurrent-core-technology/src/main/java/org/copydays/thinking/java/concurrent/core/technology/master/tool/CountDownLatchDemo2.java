package org.copydays.thinking.java.concurrent.core.technology.master.tool;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo2 {

    private final static int threadCount = 200;

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool(); // 使用线程池

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;

            exec.execute(() -> {
                try {
                    test(threadNum);
                    // countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();  // 确保程序一定执行，如果抛出异常，程序就卡死了
                }
            });
        }

        countDownLatch.await();
        System.out.println("==>所有程序员完成任务，项目顺利上线！");
        exec.shutdown();  // 关闭线程池，等待所有线程执行完毕，不写就会一直等着
    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(100);
        System.out.println(String.format("程序员[%d]完成任务。。。", threadNum));
        Thread.sleep(100);
    }
}