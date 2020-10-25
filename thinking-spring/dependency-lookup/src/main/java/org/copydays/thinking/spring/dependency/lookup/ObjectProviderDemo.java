package org.copydays.thinking.spring.dependency.lookup;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * 通过 {@link org.springframework.beans.factory.ObjectProvider} 进行依赖查找
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class ObjectProviderDemo {
    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 将当前类 ObjectProviderDemo 作为配置类 （Configuration Class）
        // 将 @Bean 定义在 ObjectProviderDemo 类中，默认就是 Configuration 类，写不写 @Configuration 注解都是一样的
        // @Configuration 是非必须的注解
        applicationContext.register(ObjectProviderDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        // 依赖查找集合对象
        lookupByObjectProvider(applicationContext);
        lookupIfAvailable(applicationContext);
        lookupByString(applicationContext);

        // 关闭应用上下文
        applicationContext.close();

    }

    private static void lookupByString(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        //Iterable<String> stringIterable = objectProvider;
        //for (String string : stringIterable) {
        //    System.out.println(string);
        //}

        // Stream -> Method reference
        objectProvider.stream().forEach(System.out::println);

    }

    private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        // User  user  = userObjectProvider.getIfAvailable(()->User.createUser());
        User user = userObjectProvider.getIfAvailable(User::createUser);
        System.out.println("当前 User 对象：" + user);

    }

    @Bean
    @Primary
    public String hello() {
        // 方法名就是 Bean 的名称 == "hello"
        return "hello";
    }

    @Bean
    public String message() {
        return "message";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());

    }

}

