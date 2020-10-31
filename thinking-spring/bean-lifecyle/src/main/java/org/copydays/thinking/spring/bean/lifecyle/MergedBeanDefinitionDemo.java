package org.copydays.thinking.spring.bean.lifecyle;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * BeanDefinition 合并示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class MergedBeanDefinitionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 基于 XML 资源 BeanDefinitionReader 实现
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        // 加载Properties资源
        // 指定字符编码 UTF-8
        String location = "META-INF/dependency-lookup-context.xml";
        Resource resource = new ClassPathResource(location);
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");

        int beanNumbers = beanDefinitionReader.loadBeanDefinitions(encodedResource);

        System.out.println("已经加载的 BeanDefinition 数量： " + beanNumbers);

        // 通过 Bean Id 和 类型 进行依赖查找
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
        User superUser = beanFactory.getBean("superUser", User.class);
        System.out.println(superUser);
    }
}

