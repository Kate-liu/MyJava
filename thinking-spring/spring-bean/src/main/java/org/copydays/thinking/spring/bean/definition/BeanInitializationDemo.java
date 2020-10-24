package org.copydays.thinking.spring.bean.definition;

import org.copydays.thinking.spring.bean.factory.DefaultUserFactoryInterface;
import org.copydays.thinking.spring.bean.factory.UserFactoryInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Bean 初始化 Demo
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
@Configuration  // Configuration 注解，表示这是一个配置 Bean
public class BeanInitializationDemo {
    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class （配置类）
        applicationContext.register(BeanInitializationDemo.class);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 非延迟初始化在 Spring 应用上下文启动完成后，被初始化
        // 延迟初始化，是依赖查找触发 Spring 上下文启动
        // 注意下面这句话的打印顺序
        System.out.println("Spring 应用上下文已启动...");

        // 依赖查找
        // @PostConstruct 注解的方法自动执行
        UserFactoryInterface userFactoryInterface = applicationContext.getBean(UserFactoryInterface.class);
        System.out.println(userFactoryInterface);

        // 注意下面这句话的打印顺序
        // close 方法，触发 应用上下文 销毁
        System.out.println("Spring 应用上下文准备关闭...");
        // 关闭 Spring 应用上下文
        applicationContext.close();
        // 注意下面这句话的打印顺序
        System.out.println("Spring 应用上下文已关闭...");


    }

    @Bean(initMethod = "initUserFactory", destroyMethod = "doDestroy")
    @Lazy(value = false)  // default is true
    public UserFactoryInterface userFactoryInterface() {
        return new DefaultUserFactoryInterface();
    }

}

