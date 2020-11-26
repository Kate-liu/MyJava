package org.copydays.thinking.java.concurrent.core.technology.master.tool;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(5);  // 满足 5个条件之后，就不管后续的执行了，直接向后走

        for (int i = 0; i < 10; i++) {
            new Thread(new readNum(i, countDownLatch)).start();
        }

        countDownLatch.await();  // 注意跟CyclicBarrier不同，这里在 主线程await，满足CountDownLatch个数条件后，就不继续await，直接执行后续操作
        System.out.println("==>各个子线程执行结束。。。。");
        System.out.println("==>主线程执行结束。。。。");
    }

    static class readNum implements Runnable {

        private int id;
        private CountDownLatch latch;

        public readNum(int id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
            synchronized (this) {
                System.out.println("id:" + id + "," + Thread.currentThread().getName());
                // latch.countDown();
                System.out.println("线程组任务" + id + "结束，其他任务继续");

                latch.countDown();
            }
        }
    }
}