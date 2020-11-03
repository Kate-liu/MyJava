package org.copydays.thinking.spring.configuration.metadata;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

/**
 * {@link PropertiesBeanDefinitionReader} 示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class PropertiesBeanDefinitionDemo {
    public static void main(String[] args) {
        // 创建 IOC 底层容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // Properties 资源的 BeanDefinitionReader 示例
        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);

        // Properties 默认使用 ISO-8859-1进行读取，存储使用UTF-8，不然会乱吗
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:/META-INF/users-bean-definitions-config.properties");
        // 转换成带有字符编码 EncodedResource 对象
        EncodedResource encodedResource = new EncodedResource(resource, "utf-8");

        int beanDefinitionCounter = beanDefinitionReader.loadBeanDefinitions(encodedResource);
        System.out.printf("已经加载 %s 个 BeanDefinition \n", beanDefinitionCounter);

        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
    }
}

