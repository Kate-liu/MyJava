package org.copydays.thinking.spring.bean.definition;

import org.copydays.thinking.spring.bean.factory.DefaultUserFactoryInterface;
import org.copydays.thinking.spring.bean.factory.UserFactory;
import org.copydays.thinking.spring.bean.factory.UserFactoryInterface;
import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

import static java.util.ServiceLoader.load;

/**
 * Bean 实例化 - 特殊的实现方式
 * 使用 {@link ServiceLoader}, {@link ServiceLoaderFactoryBean} 实现
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class SpecialBeanInstantiationDemo {
    public static void main(String[] args) {
        // 1.方式一
        // 配置 XML 配置文件
        // 启动应用上下文
        // BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");

        // 使用 XML 实现实例化
        // ServiceLoader<UserFactoryInterface> serviceLoader = beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);
        // displayServiceLoader(serviceLoader);

        // 从 ServiceLoader 中使用 PREFIX = "META-INF/services/" 实现实例化
        // 等效于上面实现方式
        // demoServiceLoader();

        // 2.方式二
        // 通过 ApplicationContext 获取 AutowireCapableBeanFactory 实现
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

        // 创建 UserFactory，通过 AutowireCapableBeanFactory
        // 创建 Bean 的时候，不能使用接口，必须使用具体实现类实现
        UserFactoryInterface userFactoryInterface = beanFactory.createBean(DefaultUserFactoryInterface.class);
        System.out.println(userFactoryInterface.createUser());

    }

    public static void demoServiceLoader() {
        ServiceLoader<UserFactoryInterface> serviceLoader = load(UserFactoryInterface.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }

    private static void displayServiceLoader(ServiceLoader<UserFactoryInterface> serviceLoader) {
        Iterator<UserFactoryInterface> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactoryInterface userFactory = iterator.next();
            System.out.println(userFactory.createUser());
        }
    }
}

