package org.copydays.thinking.spring.configuration.metadata;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link PropertySource} 外部化配置示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
@PropertySource("classpath:/META-INF/users-bean-definitions-config.properties")
public class PropertySourceDemo {

    @Bean
    public User user(@Value("${user.id}") Long id, @Value("${user.name}") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 扩展 Environment 中的 PropertySources
        Map<String, Object> source = new HashMap<>();
        source.put("user.name", "rongming");
        org.springframework.core.env.PropertySource propertySource = new MapPropertySource("first-propersourse", source);
        context.getEnvironment().getPropertySources().addFirst(propertySource);

        // 注册当前类作为 Configuration Class
        context.register(PropertySourceDemo.class);

        // 启动应用上下文
        context.refresh();

        // 依赖查找
        Map<String, User> userMap = context.getBeansOfType(User.class);
        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            System.out.printf("User Bean name: %s, content: %s \n", entry.getKey(), entry.getValue());
        }

        System.out.println(context.getEnvironment().getPropertySources());

        // 关闭 Spring 应用上下文
        context.close();
    }
}

