package org.copydays.thinking.spring.dependency.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

import javax.annotation.PostConstruct;
import javax.xml.transform.Source;

/**
 * ResolvableDependency 作为依赖来源
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class ResolvableDependencySourceDemo {

    @Autowired
    private String value;

    @PostConstruct
    public void init() {
        System.out.println(value);
    }

    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();


        // 注册 Configuration Class （配置类） --> 也是一个 Spring Bean
        applicationContext.register(ResolvableDependencySourceDemo.class);

        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            // 注册 Resolvable Dependency
            // 只能用于依赖注入，只能使用类的类型注入，不能使用名称
            beanFactory.registerResolvableDependency(String.class, "hello");
        });


        // 启动应用上下文
        applicationContext.refresh();


        // 显示的关闭 Spring 应用上下文
        applicationContext.close();
    }
}

