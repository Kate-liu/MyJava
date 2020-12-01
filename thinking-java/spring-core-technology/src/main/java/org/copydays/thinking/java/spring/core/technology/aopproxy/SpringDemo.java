package org.copydays.thinking.java.spring.core.technology.aopproxy;


import org.copydays.thinking.java.spring.core.technology.aop.ISchool;
import org.copydays.thinking.java.spring.core.technology.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        Student student123 = context.getBean(Student.class);
        Student student123 = (Student) context.getBean("student123");
        System.out.println("student123 " + student123.toString());

        Student student100 = (Student) context.getBean("student100");
        System.out.println("student100 " + student100.toString());

        Klass class1 = context.getBean(Klass.class);
        System.out.println("class1 " + class1);
        System.out.println("Klass对象AOP代理后的实际类型：" + class1.getClass());
        System.out.println("Klass对象AOP代理后的实际类型是否是Klass子类：" + (class1 instanceof Klass));

        ISchool school = context.getBean(ISchool.class);
        System.out.println("school " + school);
        System.out.println("ISchool接口的对象AOP代理后的实际类型：" + school.getClass());

        ISchool school1 = context.getBean(ISchool.class);
        System.out.println("school1 " + school1);
        System.out.println("ISchool接口的对象AOP代理后的实际类型：" + school1.getClass());

        school1.ding();

        class1.dong();

        System.out.println("   context.getBeanDefinitionNames() ===> " + String.join(",", context.getBeanDefinitionNames()));
    }
}
