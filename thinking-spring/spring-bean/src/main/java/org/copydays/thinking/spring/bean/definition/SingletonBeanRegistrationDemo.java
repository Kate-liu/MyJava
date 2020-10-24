package org.copydays.thinking.spring.bean.definition;

import org.copydays.thinking.spring.bean.factory.DefaultUserFactoryInterface;
import org.copydays.thinking.spring.bean.factory.UserFactoryInterface;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 单体 Bean 注册实例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class SingletonBeanRegistrationDemo {
    public static void main(String[] args) {

        // 1.基于 ConfigurableListableBeanFactory 实现外部注册
        /*
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 创建一个 userFactoryInterface 外部对象
        UserFactoryInterface userFactoryInterface = new DefaultUserFactoryInterface();
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        // 注册 外部单例对象
        beanFactory.registerSingleton("userFactory", userFactoryInterface);

        applicationContext.register(BeanInitializationDemo.class);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 通过 依赖查找方式 来获取 userFactory
        UserFactoryInterface userFactoryInterfaceByLookup = beanFactory.getBean("userFactory", UserFactoryInterface.class);
        System.out.println("userFactoryInterface == userFactoryInterfaceByLookup ? " + (userFactoryInterface == userFactoryInterfaceByLookup));

        // 关闭 Spring 应用上下文
        applicationContext.close();
        */

        // 2.基于 SingletonBeanRegistry 实现外部注册
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 创建一个 userFactoryInterface 外部对象
        UserFactoryInterface userFactoryInterface = new DefaultUserFactoryInterface();
        SingletonBeanRegistry singletonBeanRegistry = applicationContext.getBeanFactory();
        // 注册 外部单例对象
        singletonBeanRegistry.registerSingleton("userFactory", userFactoryInterface);

        applicationContext.register(BeanInitializationDemo.class);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 通过 依赖查找方式 来获取 userFactory
        UserFactoryInterface userFactoryInterfaceByLookup = applicationContext.getBean("userFactory", UserFactoryInterface.class);
        System.out.println("userFactoryInterface == userFactoryInterfaceByLookup ? " + (userFactoryInterface == userFactoryInterfaceByLookup));

        // 关闭 Spring 应用上下文
        applicationContext.close();
    }
}

