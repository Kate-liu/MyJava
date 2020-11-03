package org.copydays.thinking.spring.bean.lifecyle;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ObjectUtils;

/**
 * Bean 初始化生命周期示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @see BeanPostProcessor
 * @since
 */
public class InitialzationLifecyleDemo {
    public static void main(String[] args) {
        executeBeanFactory();

    }

    private static void executeBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 添加 BeanPostProcessor 实现 MyInstantiationAwareBeanPostProcessor
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        // 添加 CommonAnnotationBeanPostProcessor 解决 @PostConstruct 回调不生效问题
        beanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());

        // 基于 XML 资源 BeanDefinitionReader 实现
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        // 加载Properties资源
        // 指定字符编码 UTF-8
        String[] locations = {"META-INF/dependency-lookup-context.xml", "META-INF/bean-constructor-dependency-injection.xml"};

        int beanNumbers = beanDefinitionReader.loadBeanDefinitions(locations);
        System.out.println("已经加载的 BeanDefinition 数量： " + beanNumbers);

        // 显示执行 preInstantiateSingletons()
        // SmartInitializingSingleton 接口，通常在 Spring ApplicationContext 上使用
        beanFactory.preInstantiateSingletons();

        // 通过 Bean Id 和 类型 进行依赖查找
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
        User superUser = beanFactory.getBean("superUser", User.class);
        System.out.println(superUser);

        // 构造器注入，按照类型注入， resolveDependency
        UserHolder userHolder = beanFactory.getBean("userHolder", UserHolder.class);
        System.out.println(userHolder);

    }


}

