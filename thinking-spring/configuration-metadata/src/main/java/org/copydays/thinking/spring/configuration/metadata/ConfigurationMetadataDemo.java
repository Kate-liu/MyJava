package org.copydays.thinking.spring.configuration.metadata;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.util.ObjectUtils;

/**
 * Bean 配置元信息 示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class ConfigurationMetadataDemo {
    public static void main(String[] args) {

        // BeanDefinition 的定义（声明）
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name", "rmliu");

        // 获取
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        // 声明 BeanDefinition
        // 附加属性 (不影响 Bean 实例化，属性赋值，populate， initialize)
        beanDefinition.setAttribute("name", "荣明");
        // 当前 BeanDefinition 来自于何方, 辅助作用
        beanDefinition.setSource(ConfigurationMetadataDemo.class);

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(bean.getClass())) {
                    BeanDefinition bd = beanFactory.getBeanDefinition(beanName);

                    if (ConfigurationMetadataDemo.class.equals(bd.getSource())){
                        // attribute 是一个属性（存储）上下文
                        String name = (String) bd.getAttribute("name");

                        User user = (User) bean;
                        user.setName(name);
                    }
                }
                return bean;
            }
        });

        // 注册 user 的 BeanDefinition
        beanFactory.registerBeanDefinition("user", beanDefinition);

        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);


    }
}

