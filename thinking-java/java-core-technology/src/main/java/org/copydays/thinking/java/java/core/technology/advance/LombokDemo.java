package org.copydays.thinking.java.java.core.technology.advance;

import lombok.extern.java.Log;
import org.copydays.thinking.java.java.core.technology.advance.domain.Student;

import java.io.IOException;

@Log
public class LombokDemo {

    public static void main(String[] args) throws IOException {

        new LombokDemo().demo();

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("荣明");
        System.out.println(student1.toString());

        Student student2 = new Student(2, "rmliu");
        System.out.println(student2.toString());
    }

    private void demo() {
        log.info("demo in log.");
    }

}
