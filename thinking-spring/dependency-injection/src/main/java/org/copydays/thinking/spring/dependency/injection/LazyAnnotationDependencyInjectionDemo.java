package org.copydays.thinking.spring.dependency.injection;

import org.copydays.thinking.spring.dependency.injection.annotation.UserGroup;
import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Set;

/**
 * {@link ObjectProvider} 实现 延迟的依赖注入
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @see Qualifier
 * @since
 */
public class LazyAnnotationDependencyInjectionDemo {

    @Autowired
    private User user; // 实时注入

    @Autowired
    private ObjectProvider<User> userObjectProvider; // 延迟注入, 推荐使用 ObjectProvider, Spring 相关产品中更多的时候使用 ObjectProvider

    @Autowired
    private ObjectFactory<Set<User>> userObjectFactory;// 延迟注入, 不推荐使用

    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class （配置类） --> 也是一个 Spring Bean
        applicationContext.register(LazyAnnotationDependencyInjectionDemo.class);

        // 使用 XML 的方式，加载 Bean
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcesPath = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcesPath);


        // 启动应用上下文
        applicationContext.refresh();

        // 依赖查找 QualifierAnnotationDependencyInjectionDemo Bean
        LazyAnnotationDependencyInjectionDemo demo = applicationContext.getBean(LazyAnnotationDependencyInjectionDemo.class);

        // 输出
        System.out.println("demo.user = " + demo.user);
        System.out.println("demo.userObjectProvider = " + demo.userObjectProvider.getObject()); // 继承 ObjectFactory 中的方法
        demo.userObjectProvider.forEach(System.out::println);  // 使用 集合 的方式，输出所有的 user

        System.out.println("demo.userObjectFactory = " + demo.userObjectFactory.getObject());

        // 显示的关闭 Spring 应用上下文
        applicationContext.close();
    }
}

