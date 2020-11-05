package org.copydays.thinking.spring.configuration.metadata;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.copydays.thinking.spring.ioc.overview.enums.City;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * 基于 java 注解的 Yaml 外部化配置示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
@PropertySource(
        name = "yamlPropertySource",
        value = "classpath:/META-INF/user.yaml",
        factory = YamlPropertySourceFactory.class)
public class AnnotatedBasedYamlPropertySourceDemo {

    @Bean
    public User user(@Value("${user.id}") Long id, @Value("${user.name}") String name, @Value("${user.city}") City city) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setCity(city);
        return user;
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册当前类作为 Configuration Class
        context.register(AnnotatedBasedYamlPropertySourceDemo.class);

        // 启动应用上下文
        context.refresh();

        // 获取 Bean
        User user = context.getBean("user", User.class);
        System.out.println(user);

        // 关闭 Spring 应用上下文
        context.close();

    }
}

