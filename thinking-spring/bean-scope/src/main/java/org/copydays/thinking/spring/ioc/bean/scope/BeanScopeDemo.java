package org.copydays.thinking.spring.ioc.bean.scope;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Map;

/**
 * Bean 的作用域 示例
 * <p>
 * org.springframework.beans.factory.config.ConfigurableListableBeanFactory#registerResolvableDependency(java.lang.Class, java.lang.Object)
 * 可以注册 非 Spring 容器管理对象，使用的是 registerResolvableDependency() 方法实现
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class BeanScopeDemo implements DisposableBean {

    @Bean
    // 默认 scope 就是 singleton
    public static User singletonUser() {
        return createUser();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public static User prototypeUser() {
        return createUser();
    }

    private static User createUser() {
        User user = new User();
        user.setId(System.nanoTime());
        return user;
    }

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser;

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser2;

    @Autowired
    private Map<String, User> users;

    @Autowired
    private ConfigurableListableBeanFactory beanFactory; // Resolvable Dependency


    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class （配置类） --> 也是一个 Spring Bean
        applicationContext.register(BeanScopeDemo.class);

        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.addBeanPostProcessor(new BeanPostProcessor() {

                @Override
                public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                    System.out.printf("%s Bean 名称 ：%s 在初始化后回调...\n", bean.getClass().getName(), beanName);
                    return bean;
                }
            });
        });


        // 启动应用上下文
        applicationContext.refresh();

        // 依赖查找
        // 结论一：
        // Singleton Bean 无论依赖查找还是依赖注入，均为同一个对象
        // Prototype Bean 无论依赖查找还是依赖注入，均为新生成的对象
        //
        // 结论二：
        // 如果依赖注入集合类型的对象，Singleton Bean 和 Prototype Bean 均会存在一个
        // Prototype Bean 有别于其他地方的依赖注入
        //
        // 结论三：
        // 无论是 Singleton Bean 还是 Prototype Bean 均会执行初始化方法回调
        // 不过仅 Singleton Bean 会执行销毁方法回调
        scopeBeansByLookup(applicationContext);
        scopeBeansByInjection(applicationContext);


        // 显示的关闭 Spring 应用上下文
        applicationContext.close();
    }

    private static void scopeBeansByInjection(AnnotationConfigApplicationContext applicationContext) {
        BeanScopeDemo beanScopeDemo = applicationContext.getBean(BeanScopeDemo.class);

        System.out.println("beanScopeDemo.singletonUser " + beanScopeDemo.singletonUser);
        System.out.println("beanScopeDemo.singletonUser1 " + beanScopeDemo.singletonUser1);

        System.out.println("beanScopeDemo.prototypeUser " + beanScopeDemo.prototypeUser);
        System.out.println("beanScopeDemo.prototypeUser1 " + beanScopeDemo.prototypeUser1);
        System.out.println("beanScopeDemo.prototypeUser2 " + beanScopeDemo.prototypeUser2);

        System.out.println("beanScopeDemo.users " + beanScopeDemo.users);
    }

    private static void scopeBeansByLookup(AnnotationConfigApplicationContext applicationContext) {
        for (int i = 0; i < 3; i++) {
            // singleton 对象，是共享的 Bean 对象
            User singletonUser = applicationContext.getBean("singletonUser", User.class);
            System.out.println("singletonUser = " + singletonUser);

            // prototype 对象，是每一次依赖查找均生成新的 Bean 对象
            User prototypeUser = applicationContext.getBean("prototypeUser", User.class);
            System.out.println("prototypeUser = " + prototypeUser);
        }
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("当前 BeanScopeDemo Bean 正在销毁中...");

        this.prototypeUser.destroy();
        this.prototypeUser1.destroy();
        this.prototypeUser2.destroy();

        // 获取 BeanDefinition
        for (Map.Entry<String, User> entry : this.users.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);

            if (beanDefinition.isPrototype()){ // 如果当前 Bean 是 prototype scope
                User user = entry.getValue();
                user.destroy();
            }
        }

        System.out.println("当前 BeanScopeDemo Bean 销毁结束...");

    }
}

