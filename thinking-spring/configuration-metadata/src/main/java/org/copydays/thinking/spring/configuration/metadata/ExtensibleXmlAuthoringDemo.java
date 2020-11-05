package org.copydays.thinking.spring.configuration.metadata;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

/**
 * Spring Xml 元素扩展示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class ExtensibleXmlAuthoringDemo {
    public static void main(String[] args) {
        // 创建 IOC 底层容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 创建 XML 资源的 BeanDefinitionReader
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // 加载 XML 资源文件
        reader.loadBeanDefinitions("META-INF/user-context.xml");

        // 获取 User Bean 对象
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }
}

