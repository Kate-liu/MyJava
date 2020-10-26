package org.copydays.thinking.spring.dependency.injection;

import org.copydays.thinking.spring.dependency.injection.annotation.UserGroup;
import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

/**
 * {@link org.springframework.beans.factory.annotation.Qualifier} 注解的依赖注入
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @see org.springframework.beans.factory.annotation.Qualifier
 * @since
 */
public class QualifierAnnotationDependencyInjectionDemo {

    // 整体应用上下文存在 4 个 User 类型的 Bean
    // superUser
    // User
    // user1 --> @Qualifier
    // user2 --> @Qualifier

    // superUser --> primary=true
    @Autowired
    private User user;

    // user --> 指定 Bean 的名称或者 ID
    @Autowired
    @Qualifier("user")
    private User namedUser;

    // 2 Beans = user + superUser
    @Autowired
    private Collection<User> allUser;

    // 2 Beans = user1 + user2 --> 4 Beans = user1 + user2 + user3 + user4
    @Autowired
    @Qualifier
    private Collection<User> qualifiedUsers;

    // 2 Beans = user3 + user4
    @Autowired
    @UserGroup
    private Collection<User> groupedUsers;

    // 进行逻辑分组
    @Bean
    @Qualifier
    public User user1() {
        return createUser(7L);
    }

    // 进行逻辑分组
    @Bean
    @Qualifier
    public User user2() {
        return createUser(8L);
    }

    // 进行逻辑分组
    @Bean
    @UserGroup
    public User user3() {
        return createUser(9L);
    }

    // 进行逻辑分组
    @Bean
    @UserGroup
    public User user4() {
        return createUser(10L);
    }

    private static User createUser(Long id) {  // 工厂方法创建 User
        User user = new User();
        user.setId(id);
        return user;
    }

    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class （配置类） --> 也是一个 Spring Bean
        applicationContext.register(QualifierAnnotationDependencyInjectionDemo.class);

        // 使用 XML 的方式，加载 Bean
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcesPath = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcesPath);


        // 启动应用上下文
        applicationContext.refresh();

        // 依赖查找 QualifierAnnotationDependencyInjectionDemo Bean
        QualifierAnnotationDependencyInjectionDemo demo = applicationContext.getBean(QualifierAnnotationDependencyInjectionDemo.class);

        // 期待输出 superUser
        System.out.println("demo.user = " + demo.user);
        // 期待输出 user
        System.out.println("demo.namedUser = " + demo.namedUser);
        // 期待输出 2 Beans = user + superUser
        System.out.println("demo.allUser = " + demo.allUser);
        // 期待输出 2 Beans = user1 + user2 --> 4 Beans = user1 + user2 + user3 + user4
        System.out.println("demo.qualifiedUsers = " + demo.qualifiedUsers);
        // 期待输出 2 Beans = user3 + user4
        System.out.println("demo.groupedUsers = " + demo.groupedUsers);


        // 显示的关闭 Spring 应用上下文
        applicationContext.close();
    }
}

