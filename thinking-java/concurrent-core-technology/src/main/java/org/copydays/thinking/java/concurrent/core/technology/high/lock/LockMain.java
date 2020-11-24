package org.copydays.thinking.java.concurrent.core.technology.high.lock;

public class LockMain {

    public static void main(String[] args) {
        // 必然死锁
        // 检测工具：jvisualvm > jmc > jconsole

        Count3 count3 = new Count3();
        ThreadA threadA = new ThreadA(count3);
        threadA.setName("线程A");
        threadA.start();

        ThreadB threadB = new ThreadB(count3);
        threadB.setName("线程B");
        threadB.start();

    }

}
