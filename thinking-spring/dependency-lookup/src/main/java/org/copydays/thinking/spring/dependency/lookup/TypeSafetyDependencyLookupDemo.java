package org.copydays.thinking.spring.dependency.lookup;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 类型安全，依赖查找示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class TypeSafetyDependencyLookupDemo {
    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 将当前类 ObjectProviderDemo 作为配置类 （Configuration Class）
        // 将 @Bean 定义在 ObjectProviderDemo 类中，默认就是 Configuration 类，写不写 @Configuration 注解都是一样的
        // @Configuration 是非必须的注解
        applicationContext.register(TypeSafetyDependencyLookupDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        // 演示 BeanFactory#getBean() 方法的安全性 -- 不安全
        displayBeanFactoryGetBean(applicationContext);
        // 演示 ObjectFactory#getObject() 方法的安全性 -- 不安全
        displayObjectFactoryGetObject(applicationContext);
        // 演示 ObjectProvider#getIfAvailable() 方法的安全性 -- 安全
        displayObjectProviderGetIfAvailableGetObject(applicationContext);

        // 演示 ListableBeanFactory#getBeansOfType() 方法的安全性 -- 安全
        displayListableBeanFactoryGetBeansOfType(applicationContext);
        // 演示 ObjectProvider#stream() 方法的安全性 -- 安全
        displayObjectProviderStream(applicationContext);

        // 关闭应用上下文
        applicationContext.close();
    }

    private static void displayObjectProviderStream(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        printBeansException("displayObjectProviderStream", () -> userObjectProvider.stream().forEach(System.out::println));
    }

    private static void displayListableBeanFactoryGetBeansOfType(ListableBeanFactory beanFactory) {
        printBeansException("displayListableBeanFactoryGetBeansOfType", () -> beanFactory.getBeansOfType(User.class));
    }

    private static void displayObjectProviderGetIfAvailableGetObject(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        printBeansException("displayObjectProviderGetIfAvailableGetObject", () -> userObjectProvider.getIfAvailable());
    }

    private static void displayObjectFactoryGetObject(AnnotationConfigApplicationContext applicationContext) {
        // ObjectProvider is ObjectFactory
        ObjectFactory<User> userObjectFactory = applicationContext.getBeanProvider(User.class);
        printBeansException("displayObjectFactoryGetObject", () -> userObjectFactory.getObject());
    }

    public static void displayBeanFactoryGetBean(BeanFactory beanFactory) {
        printBeansException("displayBeanFactoryGetBean", () -> beanFactory.getBean(User.class));
    }

    private static void printBeansException(String source, Runnable runnable) {
        // System.out.println("Source form " + source);
        System.err.println("Source form " + source);
        System.err.println("=========================");
        try {
            runnable.run();
        } catch (BeansException exception) {
            exception.printStackTrace();
        }
    }
}

