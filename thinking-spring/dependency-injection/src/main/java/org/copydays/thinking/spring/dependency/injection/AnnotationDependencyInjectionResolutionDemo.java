package org.copydays.thinking.spring.dependency.injection;

import org.copydays.thinking.spring.dependency.injection.annotation.InjectedUser;
import org.copydays.thinking.spring.dependency.injection.annotation.MyAutowired;
import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.util.*;

import static org.springframework.context.annotation.AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME;

/**
 * 注解驱动的依赖注入处理过程
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @see Qualifier
 * @since
 */
public class AnnotationDependencyInjectionResolutionDemo {

    @Autowired
    @Lazy
    private User lazyUser;  // 依赖查找 - 延迟 (返回一个 CGLIB 提升过的 AOP 代理对象，没有进入 resolve)

    @Autowired
    private User user; // DependencyDescriptor -->
    // 必须（required=true），实时注入（eager=true），通过类型 User.class 依赖查找（处理），字段名称 user，是否首要（primary = true）

    @Autowired
    private Map<String, User> users;  // 集合类型的依赖注入，user, superUser

    @MyAutowired
    private Optional<User> userOptional;  // java8 之后，可以将其包装成为一个可选的

    @Inject
    private User injectedUser;  // 标准 JSR-330's

    @InjectedUser
    private User myInjectUser;  // 自定义扩展

//    @Bean(name = AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
//    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {  // 标注 static，可以保证这个 Bean 脱离原来类注册 Bean 的束缚，可以自己进行提前与独立的进行 注册
//        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
//        // @Autowired + @Inject + 新注解 @InjectedUser
//        // 如果  @Inject 不存在，会在提前注入的时候 报编译错误，优美解决见下面
//        Set<Class<? extends Annotation>> autowiredAnnotationTypes = new LinkedHashSet<>(Arrays.asList(Autowired.class, Inject.class, InjectedUser.class));
//        beanPostProcessor.setAutowiredAnnotationTypes(autowiredAnnotationTypes);
//
//        return beanPostProcessor;
//    }

    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE - 3)  // 基于优先级，保证新老注解的同时存在
    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        beanPostProcessor.setAutowiredAnnotationType(InjectedUser.class);

        return beanPostProcessor;
    }

    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class （配置类） --> 也是一个 Spring Bean
        applicationContext.register(AnnotationDependencyInjectionResolutionDemo.class);

        // 使用 XML 的方式，加载 Bean
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcesPath = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcesPath);


        // 启动应用上下文
        applicationContext.refresh();

        // 依赖查找 QualifierAnnotationDependencyInjectionDemo Bean
        AnnotationDependencyInjectionResolutionDemo demo = applicationContext.getBean(AnnotationDependencyInjectionResolutionDemo.class);

        // 输出
        System.out.println("demo.user = " + demo.user);
        System.out.println("demo.users = " + demo.users);  // 集合类型的输出顺序，和定义的顺序是一致的，先定义，先取出，先输出
        System.out.println("demo.userOptional = " + demo.userOptional);
        System.out.println("demo.injectedUser = " + demo.injectedUser);
        System.out.println("demo.myInjectUser = " + demo.myInjectUser);

        // 显示的关闭 Spring 应用上下文
        applicationContext.close();
    }
}

