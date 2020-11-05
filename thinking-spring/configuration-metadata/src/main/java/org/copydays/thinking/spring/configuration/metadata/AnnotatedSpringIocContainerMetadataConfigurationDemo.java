package org.copydays.thinking.spring.configuration.metadata;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Map;

/**
 * 基于 Java 注解 Spring Ioc 容器元信息配置示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
// 将当前类作为 Configuration class
@ImportResource("classpath:/META-INF/dependency-lookup-context.xml")
@Import(User.class)
@PropertySource("classpath:/META-INF/users-bean-definitions-config.properties")
// java8, @Repeatable 支持，可写多个 PropertySource
@PropertySource("classpath:/META-INF/users-bean-definitions-config.properties")
public class AnnotatedSpringIocContainerMetadataConfigurationDemo {

    // user.name 是 java Properties 默认存在，当前用户为 rmliu
    @Bean
    public User configuredUser(@Value("${user.id}") Long id, @Value("${user.name}") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册当前类作为 Configuration Class
        context.register(AnnotatedSpringIocContainerMetadataConfigurationDemo.class);

        // 启动应用上下文
        context.refresh();

        // 依赖查找
        Map<String, User> userMap = context.getBeansOfType(User.class);
        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            System.out.printf("User Bean name: %s, content: %s \n", entry.getKey(), entry.getValue());
        }

        // 关闭 Spring 应用上下文
        context.close();
    }
}

