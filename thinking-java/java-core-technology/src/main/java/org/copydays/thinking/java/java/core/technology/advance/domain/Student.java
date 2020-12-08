package org.copydays.thinking.java.java.core.technology.advance.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.Serializable;


@Data  // 在编译的时候，可以看反编译的文件中，会直接就生成了所有的 getter setter  ...
@NoArgsConstructor
@ToString
@Slf4j  // 在编译的时候，可以看反编译的文件中，会自动加上 private static final Logger log = LoggerFactory.getLogger(Student.class);
public class Student implements Serializable, ApplicationContextAware {

    private int id;
    private String name;

    private ApplicationContext applicationContext;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void init() {
        System.out.println("hello...........");
        log.debug("ddddddddddddddd");
        log.info("no info...");
    }

    public Student create() {
        this.applicationContext.getBeanDefinitionNames();
        Student s = new Student(101, "KK101");
        return s;
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
