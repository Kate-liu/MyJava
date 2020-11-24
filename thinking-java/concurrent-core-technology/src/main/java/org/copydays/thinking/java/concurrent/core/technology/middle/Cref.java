package org.copydays.thinking.java.concurrent.core.technology.middle;


public class Cref {
    public static void main(String[] args) {
        int x = Counter.A; // 与 int x = 10 的 javap -c xxx 反编译一样
        int y = Counter.B;
    }
}
