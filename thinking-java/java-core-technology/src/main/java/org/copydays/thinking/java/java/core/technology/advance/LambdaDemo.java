package org.copydays.thinking.java.java.core.technology.advance;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

//  使用泛型 约束必须是 序列化（Serializable）的子类型
//  也可以约束其满足 n 个类型
public class LambdaDemo<T extends Serializable & Comparable & Collection> {

    public static void main(String[] args) {
        LambdaDemo lambdaDemo = new LambdaDemo();

        // java 7
        MathOperation op = new MathOperation() {
            @Override
            public Integer operation(int a, int b) {
                return 1;
            }
        };

        // lambda
        MathOperation op1 = (a, b) -> 1;

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;
        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b + 1.0;
        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            int c = 11;
            return a * b * c;
        };
        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("1 = " + lambdaDemo.operate(1, 1, op));
        System.out.println("1 = " + lambdaDemo.operate(1, 1, op1));
        System.out.println("10 + 2 = " + lambdaDemo.operate(10, 2, addition));
        System.out.println("10 - 2 = " + lambdaDemo.operate(10, 2, subtraction));
        System.out.println("10 * 2 = " + lambdaDemo.operate(10, 2, multiplication));
        System.out.println("10 / 2 = " + lambdaDemo.operate(10, 2, division));

        System.out.println("10 ^ 2 = " + lambdaDemo.operate(10, 2, (a, b) -> new Double(Math.pow(a, b)).intValue()));
        System.out.println("10 ^ 2 = " + lambdaDemo.operate(10, 2, (a, b) -> (int) Math.pow(a, b)));

        // 不用括号
        GreetingService greetingService1 = message -> {
            System.out.println("hello " + message);
        };
        // 用括号
        GreetingService greetingService2 = (message) -> {
            System.out.println("hello " + message);
        };
        // :: 表示方法引用
        GreetingService greetingService3 = System.out::println;

        greetingService1.sayMessage("rmliu");
        greetingService2.sayMessage("java");
        greetingService3.sayMessage("ting");

        // forEach
        Arrays.asList(1, 2, 3).forEach(x -> System.out.println(x + 3));
        Arrays.asList(1, 2, 3).forEach(System.out::println);
        Arrays.asList(1, 2, 3).forEach(LambdaDemo::println);

    }

    private static void println(int x) {
        System.out.println(x + 3);
    }

    interface MathOperation<T> {
        T operation(int a, int b);  // 函数签名：返回类型+函数名+参数类型的列表
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private <T> T operate(int a, int b, MathOperation<T> mathOperation) {
        return mathOperation.operation(a, b);
    }
}
