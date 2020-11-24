package org.copydays.thinking.java.jvm.core.technology.bytecode;

public class ForLoopTestJavaPDetial {
    // 展示 HelloByteCode 进行反编译后的结果
    // 输出变量变和栈大小的，更详细信息
}
//Classfile /E:/09-面试/MyJava/thinking-java/jvm-core-technology/src/org/copydays/thinking/java/jvm/core/technology/ForLoopTest.class
//Last modified 2020-11-17; size 683 bytes
//        MD5 checksum 094b82ce276963ddf1c8aec74d0f54f0
//        Compiled from "ForLoopTest.java"
//public class org.copydays.thinking.java.jvm.core.technology.ForLoopTest
//        minor version: 0
//        major version: 52
//        flags: ACC_PUBLIC, ACC_SUPER
//        Constant pool:
//        #1 = Methodref          #8.#24         // java/lang/Object."<init>":()V
//        #2 = Class              #25            // org/copydays/thinking/java/jvm/core/technology/MovingAverage
//        #3 = Methodref          #2.#24         // org/copydays/thinking/java/jvm/core/technology/MovingAverage."<init>":()V
//        #4 = Fieldref           #7.#26         // org/copydays/thinking/java/jvm/core/technology/ForLoopTest.numbers:[I
//        #5 = Methodref          #2.#27         // org/copydays/thinking/java/jvm/core/technology/MovingAverage.submit:(D)V
//        #6 = Methodref          #2.#28         // org/copydays/thinking/java/jvm/core/technology/MovingAverage.getAvg:()D
//        #7 = Class              #29            // org/copydays/thinking/java/jvm/core/technology/ForLoopTest
//        #8 = Class              #30            // java/lang/Object
//        #9 = Utf8               numbers
//        #10 = Utf8               [I
//        #11 = Utf8               <init>
//  #12 = Utf8               ()V
//          #13 = Utf8               Code
//          #14 = Utf8               LineNumberTable
//          #15 = Utf8               main
//          #16 = Utf8               ([Ljava/lang/String;)V
//          #17 = Utf8               StackMapTable
//          #18 = Class              #31            // "[Ljava/lang/String;"
//          #19 = Class              #25            // org/copydays/thinking/java/jvm/core/technology/MovingAverage
//          #20 = Class              #10            // "[I"
//          #21 = Utf8               <clinit>
//  #22 = Utf8               SourceFile
//          #23 = Utf8               ForLoopTest.java
//          #24 = NameAndType        #11:#12        // "<init>":()V
//          #25 = Utf8               org/copydays/thinking/java/jvm/core/technology/MovingAverage
//          #26 = NameAndType        #9:#10         // numbers:[I
//          #27 = NameAndType        #32:#33        // submit:(D)V
//          #28 = NameAndType        #34:#35        // getAvg:()D
//          #29 = Utf8               org/copydays/thinking/java/jvm/core/technology/ForLoopTest
//          #30 = Utf8               java/lang/Object
//          #31 = Utf8               [Ljava/lang/String;
//          #32 = Utf8               submit
//          #33 = Utf8               (D)V
//          #34 = Utf8               getAvg
//          #35 = Utf8               ()D
//          {
//public org.copydays.thinking.java.jvm.core.technology.ForLoopTest();
//        descriptor: ()V
//        flags: ACC_PUBLIC
//        Code:
//        stack=1, locals=1, args_size=1
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return
//        LineNumberTable:
//        line 3: 0
//
//public static void main(java.lang.String[]);
//        descriptor: ([Ljava/lang/String;)V
//        flags: ACC_PUBLIC, ACC_STATIC
//        Code:
//        stack=3, locals=6, args_size=1
//        0: new           #2                  // class org/copydays/thinking/java/jvm/core/technology/MovingAverage
//        3: dup
//        4: invokespecial #3                  // Method org/copydays/thinking/java/jvm/core/technology/MovingAverage."<init>":()V
//        7: astore_1
//        8: getstatic     #4                  // Field numbers:[I
//        11: astore_2
//        12: aload_2
//        13: arraylength
//        14: istore_3
//        15: iconst_0
//        16: istore        4
//        18: iload         4
//        20: iload_3
//        21: if_icmpge     43
//        24: aload_2
//        25: iload         4
//        27: iaload
//        28: istore        5
//        30: aload_1
//        31: iload         5
//        33: i2d
//        34: invokevirtual #5                  // Method org/copydays/thinking/java/jvm/core/technology/MovingAverage.submit:(D)V
//        37: iinc          4, 1
//        40: goto          18
//        43: aload_1
//        44: invokevirtual #6                  // Method org/copydays/thinking/java/jvm/core/technology/MovingAverage.getAvg:()D
//        47: dstore_2
//        48: return
//        LineNumberTable:
//        line 7: 0
//        line 9: 8
//        line 10: 30
//        line 9: 37
//        line 13: 43
//        line 14: 48
//        StackMapTable: number_of_entries = 2
//        frame_type = 255 /* full_frame */
//        offset_delta = 18
//        locals = [ class "[Ljava/lang/String;", class org/copydays/thinking/java/jvm/core/technology/MovingAverage, class "[I", int, int ]
//        stack = []
//        frame_type = 248 /* chop */
//        offset_delta = 24
//
//static {};
//        descriptor: ()V
//        flags: ACC_STATIC
//        Code:
//        stack=4, locals=0, args_size=0
//        0: iconst_3
//        1: newarray       int
//        3: dup
//        4: iconst_0
//        5: iconst_1
//        6: iastore
//        7: dup
//        8: iconst_1
//        9: bipush        6
//        11: iastore
//        12: dup
//        13: iconst_2
//        14: bipush        8
//        16: iastore
//        17: putstatic     #4                  // Field numbers:[I
//        20: return
//        LineNumberTable:
//        line 4: 0
//        }
//        SourceFile: "ForLoopTest.java"


