package org.copydays.thinking.java.jvm.core.technology.bytecode;

public class ForLoopTest {
    private static int[] numbers = {1, 6, 8};

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage();

        for (int number : numbers) {
            ma.submit(number);
        }

        double avg = ma.getAvg();
    }
}
// javac org/copydays/thinking/java/jvm/core/technology/ForLoopTest.java
// javap -c org/copydays/thinking/java/jvm/core/technology/ForLoopTest
// javap -c -verbose org/copydays/thinking/java/jvm/core/technology/ForLoopTest
