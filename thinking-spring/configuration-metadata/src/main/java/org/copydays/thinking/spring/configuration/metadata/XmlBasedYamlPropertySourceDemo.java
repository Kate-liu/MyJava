package org.copydays.thinking.spring.configuration.metadata;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * 基于 XML 资源的 Yaml 外部化配置示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class XmlBasedYamlPropertySourceDemo {
    public static void main(String[] args) {
        // 创建 IOC 底层容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 创建 XML 资源的 BeanDefinitionReader
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // 加载 XML 资源文件
        reader.loadBeanDefinitions("META-INF/yaml-property-source-context.xml");

        // 获取 Map 的 Yaml 对象
        Map<String, Object> map = beanFactory.getBean("yamlMap", Map.class);
        System.out.println(map);
    }
}

