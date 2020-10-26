package org.copydays.thinking.spring.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于 Api 实现依赖 Constructor 注入 示例
 * (手动方式)
 * (属于最底层的实现，是 Spring Framework 依赖注入最核心的实现)
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class ApiDependencyConstructorInjectionDemo {
    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 生成 UserHolder 的 BeanDefinition
        BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();
        // 注册 UserHolder 的 BeanDefinition
        applicationContext.registerBeanDefinition("userHolder", userHolderBeanDefinition);

        // 使用 XML 的方式，加载 Bean
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcesPath = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcesPath);


        // 启动应用上下文
        applicationContext.refresh();

        // 依赖查找，创建 Bean
        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);


        // 显示的关闭 Spring 应用上下文
        applicationContext.close();
    }

    /**
     * 为  {@link UserHolder} 生成 {@link BeanDefinition}
     *
     * @return
     */
    private static BeanDefinition createUserHolderBeanDefinition() {
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);

        // addConstructorArgReference() 的时候，只需要一个参数 beanName，
        // 主要是因为 构造器参数是有顺序的，按照顺序直接即可
        // 使用 Setter 的时候，缺陷就是无顺序的
        definitionBuilder.addConstructorArgReference("superUser");

        return definitionBuilder.getBeanDefinition();
    }

}

