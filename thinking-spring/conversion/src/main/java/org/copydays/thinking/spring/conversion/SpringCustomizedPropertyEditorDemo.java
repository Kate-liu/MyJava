package org.copydays.thinking.spring.conversion;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyEditor;

/**
 * Spring 自定义 {@link PropertyEditor} 示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @see PropertyEditor
 * @since
 */
public class SpringCustomizedPropertyEditorDemo {
    public static void main(String[] args) {
        // 创建并且启动 BeanFactory 容器
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/property-editors-context.xml");

        // 类型转换传递过程
        // AbstractApplicationContext -> "conversionService" ConversionService Bean ->
        // ConfigurableBeanFactory#setConversionService(ConversionService) ->
        // AbstractAutowireCapableBeanFactory.instantiateBean ->
        // AbstractBeanFactory#getConversionService ->

        // BeanDefinition -> BeanWrapper -> 属性转换（数据来源：PropertyValues） ->
        // setPropertyValues(PropertyValues) -> TypeConverter#convertIfNessnary ->
        // TypeConverterDelegate#convertIfNessnary -> PropertyEditor or ConversionService

        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);


        applicationContext.close();
    }
}

