package org.copydays.thinking.java.java.core.technology.advance;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import org.copydays.thinking.java.java.core.technology.advance.domain.Student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

// Guava EventBus
public class GuavaDemo {

    // 提前注册得到 bus
    static EventBus bus = new EventBus();

    static {
        bus.register(new GuavaDemo());
    }

    @SneakyThrows
    public static void main(String[] args) throws IOException {

        // Joiner
        // Splitter
        List<String> lists = testString();

        // Lists
        List<Integer> list = testList();

        // ArrayListMultimap
        // Multimap
        testMap(list);

        // HashBiMap
        // BiMap
        testBiMap(lists);

        // AEvent
        testEventBus();

    }

    private static void testEventBus() {
        // EventBus
        // SPI+service loader
        // Callback/Listener
        Student student2 = new Student(2, "rmliu");
        System.out.println("I want " + student2 + " run now.");

        bus.post(new AEvent(student2));  // 只需要 post 一下，就可以 回调 @Subscribe 的方法
    }

    private static void testBiMap(List<String> lists) {
        BiMap<String, Integer> words = HashBiMap.create();
        words.put("First", 1);
        words.put("Second", 2);
        words.put("Third", 3);

        System.out.println(words.get("Second").intValue());
        System.out.println(words.inverse().get(3));  // 可以直接将 key - value 结构中的，key 变成 value，更方便 根据 value 进行反查 key

        Map<String, String> map1 = Maps.toMap(lists.listIterator(), a -> a + "-value");
        print(map1);
    }

    private static void testMap(List<Integer> list) {
        // Map map = list.stream().collect(Collectors.toMap(a->a,a->(a+1)));
        Multimap<Integer, Integer> bMultimap = ArrayListMultimap.create();

        list.forEach(
                a -> bMultimap.put(a, a + 1)
        );

        print(bMultimap);
    }

    private static List<Integer> testList() {
        // 更强的集合操作
        // 简化 创建
        List<Integer> list = Lists.newArrayList(4, 2, 3, 5, 1, 2, 2, 7, 6);

        List<List<Integer>> list1 = Lists.partition(list, 3);
        print(list1);

        return list;
    }

    private static List<String> testString() {
        // 字符串处理
        List<String> lists = Lists.newArrayList("a", "b", "g", "8", "9");

        String result = Joiner.on(",").join(lists);
        System.out.println(result);

        String test = "34344,34,34,哈哈";
        lists = Splitter.on(",").splitToList(test);
        System.out.println(lists);

        return lists;
    }

    private static void print(Object obj) {
        System.out.println(JSON.toJSONString(obj));
    }

    @Data
    @AllArgsConstructor
    public static class AEvent {
        private Student student;
    }

    @Subscribe
    public void handler(AEvent ae) {
        System.out.println(ae.student + " is running.");
    }
}
