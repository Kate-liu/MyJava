package org.copydays.thinking.spring.bean.definition;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 实例化
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class BeanInstantiationDemo {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/Bean-instantiation-context.xml");

        // 常规方式实例化 Bean
        User userStaticMethod = beanFactory.getBean("user-by-static-method", User.class);
        User userInstanceMethod = beanFactory.getBean("user-by-instance-method", User.class);
        User userFactoryBeanMethod = beanFactory.getBean("user-by-factory-bean-method", User.class);


        System.out.println(userStaticMethod);
        System.out.println(userInstanceMethod);
        System.out.println(userFactoryBeanMethod);
        System.out.println(userStaticMethod == userInstanceMethod);
        System.out.println(userStaticMethod == userFactoryBeanMethod);


    }
}

