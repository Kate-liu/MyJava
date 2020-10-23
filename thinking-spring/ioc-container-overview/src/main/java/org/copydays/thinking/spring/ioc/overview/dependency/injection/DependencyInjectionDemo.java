package org.copydays.thinking.spring.ioc.overview.dependency.injection;

import org.copydays.thinking.spring.ioc.overview.annotation.Super;
import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.copydays.thinking.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * 依赖注入示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");

        // 依赖来源一：userRepository 是自定义的 bean
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        System.out.println(userRepository.getUsers());

        // 查看userRepository
        // 依赖注入
        // 依赖来源二：beanFactory 是内建的依赖
        System.out.println(userRepository.getBeanFactory());
        System.out.println(userRepository.getBeanFactory() == beanFactory);  // false
        // 依赖查找(报错：beanFactory不是一个普通的bean)
        // System.out.println(beanFactory.getBean(BeanFactory.class));

        // 延时注入
        // ObjectFactory userFactory = userRepository.getUserObjectFactory();  //使用user集合
        // System.out.println(userFactory.getObject());
        ObjectFactory userFactory = userRepository.getObjectFactory();  //使用ApplicationContext集合
        System.out.println(userFactory.getObject());
        System.out.println(userFactory.getObject() == beanFactory);  // true

        // 依赖来源三：容器内建 Bean（容器初始化Bean）
        // Environment 抽象
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean:" + environment);
    }

    private static void whoIsIocContainer(UserRepository userRepository, BeanFactory beanFactory) {
        // ConfigurableApplicationContext <- ApplicationContext <- BeanFactory
        // ConfigurableApplicationContext#getBeanFactory()

        // 这个表达式为什么不成立？
        // 原因： BeanFactory 和 ApplicationContext 并不是一个对象
        // 最底层使用的是BeanFactory，ApplicationContext是组合了 BeanFactory 成为一个 DefaultListableBeanFactory，
        // 所以在使用 ApplicationContext 的时候，不可以直接替换为 BeanFactory ，需要调用 getBeanFactory() 方法，获得组合对象之后，在进行真正的调用
        // 使用 BeanFactory 和 ApplicationContext 的这种方式，类似于 代理模式 。
        System.out.println(userRepository.getBeanFactory() == beanFactory);

        // ApplicationContext is BeanFactory
        // https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-introduction
        // The BeanFactory interface provides an advanced configuration mechanism capable of managing any type of object.
        // ApplicationContext is a sub-interface of BeanFactory.It adds:
        // Easier integration with Spring’s AOP features
        // Message resource handling( for use in internationalization)
        // Event publication
        // Application - layer specific contexts such as the WebApplicationContext for use in web applications.
        // In short,the BeanFactory provides the configuration framework and basic functionality, and
        // the ApplicationContext adds more enterprise - specific functionality.

        // 在new ClassPathXmlApplicationContext 的时候，使用ApplicationContext 代替 BeanFactory
        // 此时，依然不会报错，可以使用
    }


}

