package org.copydays.thinking.spring.bean.definition;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * 注解 BeanDefinition 示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
// 3.通过 @Import 来进行导入
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // java 注解元信息
        // 1.通过 @Bean 的方式定义
        // 注册 Configuration Class （配置类）
        applicationContext.register(Config.class);
        // 2.通过 @Component 方式
        // 3.通过 @Import 来进行导入

        // java API 配置元信息
        // 通过 BeanDefinition 注册 API 实现
        // 1.命名 Bean 的注册方式
        registerUserBeanDefinition(applicationContext, "kate-rmliu");
        // 2.非命名 Bean 的注册方式
        registerUserBeanDefinition(applicationContext);

        // 启动应用上下文
        applicationContext.refresh();

        // 按照类型 依赖查找（不会重复注册）
        Map<String, Config> configBeans = applicationContext.getBeansOfType(Config.class);
        System.out.println("Config 类型的所有 Beans: " + applicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型的所有 Beans: " + applicationContext.getBeansOfType(User.class));


        // 显示的关闭 Spring 应用上下文
        applicationContext.close();
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id", 1L)
                .addPropertyValue("name", "rmliu");

        // 判断如果 beanName 参数存在时
        if (StringUtils.hasText(beanName)) {
            // 注册 BeanDefinition
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            // 非命名的 Bean 注册方式
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }

    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);

    }


    // 2.通过 @Component 方式
    @Component  // 定义当前类作为 Spring Bean 组件，扫描之后自动加载
    public static class Config {
        /**
         * 通过 Java 注解的方式，定义了一个 Bean
         */
        // 1.通过 @Bean 的方式定义
        @Bean(name = {"user", "rmliuUser"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("rmliu");
            return user;
        }


    }

}

