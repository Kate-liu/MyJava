package org.copydays.thinking.java.concurrent.core.technology.master.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamParallelDemo {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        IntStream.range(1, 10000).forEach(i -> list.add(i));

        BlockingQueue<Long> blockingQueue = new LinkedBlockingQueue(10000);

        // 并行，默认使用CPU * 2个线程
        List<Long> longList = list.stream().parallel()
                .map(i -> i.longValue())
                .map(i -> i + 1)
                .sorted()
                .collect(Collectors.toList());

        // 串行，单线程，因为没有.parallel()
        longList.stream().forEach(
                i -> {
                    try {
                        blockingQueue.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        System.out.println("blockingQueue:" + blockingQueue.toString());
    }


}
