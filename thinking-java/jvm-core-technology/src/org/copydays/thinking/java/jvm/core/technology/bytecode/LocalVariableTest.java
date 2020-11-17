package org.copydays.thinking.java.jvm.core.technology.bytecode;

public class LocalVariableTest {
    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage();
        int num1 = 1;
        int num2 = 2;
        ma.submit(num1);
        ma.submit(num2);

        double avg = ma.getAvg();
    }
}

// javac org/copydays/thinking/java/jvm/core/technology/LocalVariableTest.java
// javap -c org/copydays/thinking/java/jvm/core/technology/LocalVariableTest
// javap -c -verbose org/copydays/thinking/java/jvm/core/technology/LocalVariableTest
