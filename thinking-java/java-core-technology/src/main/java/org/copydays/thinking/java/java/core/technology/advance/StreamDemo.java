package org.copydays.thinking.java.java.core.technology.advance;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

// Stream 示例
public class StreamDemo {

    public static void main(String[] args) throws IOException {

        List<Integer> list = Arrays.asList(4, 2, 3, 5, 1, 2, 2, 7, 6);
        print(list);

        // Optional
        // Optional 防止 后续操作出现 null 的问题，包装成 Optional
        // orElse 给定一个默认值，如果不存在就是要默认值
        // map
        Optional<Integer> first = list.stream().findFirst();
        System.out.println(first.map(i -> i * 100).orElse(100));

        // 数组只能先包装成 stream 才可以进行后续操作
        int[] arr1 = new int[]{1, 2, 3, 4};
        System.out.println("array sum = " + Arrays.stream(arr1).sum());

        // filter
        // distinct
        // reduce, 需要给定一个初始值，后续的值分别拿过来 作为另一个加数 进行相加操作，没法进行并行操作，只能串行
        int sum = list.stream().filter(i -> i < 4).distinct().reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);

        // Map map = list.stream().collect(Collectors.toMap(a->a,a->(a+1)));
        // LinkedHashMap 是有序的
        // (a, b) -> a 进行去重
        // parallelStream
        // collect
        Map<Integer, Integer> map = list.parallelStream().collect(Collectors.toMap(a -> a, a -> (a + 1), (a, b) -> a, LinkedHashMap::new));
        print(map);

        map.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));

        List<Integer> list1 = map.entrySet().parallelStream().map(e -> e.getKey() + e.getValue()).collect(Collectors.toList());
        print(list1);

        // parallelStream()
        // 总结：
        // 1. Fluent API：继续Stream
        // 2. 终止操作：得到结果

    }

    private static void print(Object obj) {
        System.out.println(JSON.toJSONString(obj));
    }
}
