package org.copydays.thinking.java.jvm.core.technology.bytecode;

public class LocalVariableTestJavaPDetial {
    // 展示 HelloByteCode 进行反编译后的结果
    // 输出变量变和栈大小的，更详细信息
}
/**
 Classfile /E:/09-面试/MyJava/thinking-java/jvm-core-technology/src/org/copydays/thinking/java/jvm/core/technology/LocalVariableTest.class
 Last modified 2020-11-17; size 502 bytes
 MD5 checksum 06e6626e8e1a0e24d6e638bb306c18d2
 Compiled from "LocalVariableTest.java"
 public class org.copydays.thinking.java.jvm.core.technology.LocalVariableTest
 minor version: 0
 major version: 52
 flags: ACC_PUBLIC, ACC_SUPER
 Constant pool:
 #1 = Methodref          #7.#16         // java/lang/Object."<init>":()V
 #2 = Class              #17            // org/copydays/thinking/java/jvm/core/technology/MovingAverage
 #3 = Methodref          #2.#16         // org/copydays/thinking/java/jvm/core/technology/MovingAverage."<init>":()V
 #4 = Methodref          #2.#18         // org/copydays/thinking/java/jvm/core/technology/MovingAverage.submit:(D)V
 #5 = Methodref          #2.#19         // org/copydays/thinking/java/jvm/core/technology/MovingAverage.getAvg:()D
 #6 = Class              #20            // org/copydays/thinking/java/jvm/core/technology/LocalVariableTest
 #7 = Class              #21            // java/lang/Object
 #8 = Utf8               <init>
 #9 = Utf8               ()V
 #10 = Utf8               Code
 #11 = Utf8               LineNumberTable
 #12 = Utf8               main
 #13 = Utf8               ([Ljava/lang/String;)V
 #14 = Utf8               SourceFile
 #15 = Utf8               LocalVariableTest.java
 #16 = NameAndType        #8:#9          // "<init>":()V
 #17 = Utf8               org/copydays/thinking/java/jvm/core/technology/MovingAverage
 #18 = NameAndType        #22:#23        // submit:(D)V
 #19 = NameAndType        #24:#25        // getAvg:()D
 #20 = Utf8               org/copydays/thinking/java/jvm/core/technology/LocalVariableTest
 #21 = Utf8               java/lang/Object
 #22 = Utf8               submit
 #23 = Utf8               (D)V
 #24 = Utf8               getAvg
 #25 = Utf8               ()D
 {
 public org.copydays.thinking.java.jvm.core.technology.LocalVariableTest();
 descriptor: ()V
 flags: ACC_PUBLIC
 Code:
 stack=1, locals=1, args_size=1
 0: aload_0
 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 4: return
 LineNumberTable:
 line 3: 0

 public static void main(java.lang.String[]);
 descriptor: ([Ljava/lang/String;)V
 flags: ACC_PUBLIC, ACC_STATIC
 Code:
 stack=3, locals=6, args_size=1
 0: new           #2                  // class org/copydays/thinking/java/jvm/core/technology/MovingAverage
 3: dup
 4: invokespecial #3                  // Method org/copydays/thinking/java/jvm/core/technology/MovingAverage."<init>":()V
 7: astore_1
 8: iconst_1
 9: istore_2
 10: iconst_2
 11: istore_3
 12: aload_1
 13: iload_2
 14: i2d
 15: invokevirtual #4                  // Method org/copydays/thinking/java/jvm/core/technology/MovingAverage.submit:(D)V
 18: aload_1
 19: iload_3
 20: i2d
 21: invokevirtual #4                  // Method org/copydays/thinking/java/jvm/core/technology/MovingAverage.submit:(D)V
 24: aload_1
 25: invokevirtual #5                  // Method org/copydays/thinking/java/jvm/core/technology/MovingAverage.getAvg:()D
 28: dstore        4
 30: return
 LineNumberTable:
 line 5: 0
 line 6: 8
 line 7: 10
 line 8: 12
 line 9: 18
 line 11: 24
 line 12: 30
 }
 SourceFile: "LocalVariableTest.java"


 **/

