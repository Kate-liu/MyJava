package org.copydays.thinking.java.jvm.core.technology.jvm.advanced;


public abstract class Passenger {
    abstract void passThroughImmigration();

    public static void main(String[] args) {
        Passenger a = new ChinesePassenger();
        Passenger b = new ForeignerPassenger();

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            Passenger c = (i < 1_000_000_000) ? a : b;
            c.passThroughImmigration();
        }
    }
}

class ChinesePassenger extends Passenger {
    @Override
    void passThroughImmigration() {
    }
}

class ForeignerPassenger extends Passenger {
    @Override
    void passThroughImmigration() {
    }
}
// javac org/copydays/thinking/java/jvm/core/technology/jvm/advanced/Passenger.java
// java -XX:CompileCommand="dontinline,*.passThroughImmigration" org/copydays/thinking/java/jvm/core/technology/jvm/advanced/Passenger
// CompilerOracle: dontinline *.passThroughImmigration
//        244
//        234
//        233
//        232
//        233
//        232
//        232
//        232
//        233
//        233  // ChinesePassenger 单态内联缓存
//        268  // ForeignerPassenger 超多态内联缓存
//        268
//        268
//        267
//        267
//        267
//        268
//        268
//        267
//        268
