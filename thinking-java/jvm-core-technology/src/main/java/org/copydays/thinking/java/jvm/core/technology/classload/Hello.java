package org.copydays.thinking.java.jvm.core.technology.classload;

public class Hello {
    static {
        System.out.println("Hello Class Initialized!");
    }
}

// javac org/copydays/thinking/java/jvm/core/technology/classload/Hello.java
// javap -c org/copydays/thinking/java/jvm/core/technology/classload/Hello
// javap -c -verbose org/copydays/thinking/java/jvm/core/technology/classload/Hello