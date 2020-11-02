package org.copydays.thinking.spring.bean.lifecyle;

import org.copydays.thinking.spring.ioc.overview.domain.SuperUser;
import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.ObjectUtils;

/**
 * Bean 实例化生命周期示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class InstantiationLifecyleDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 添加 Bean PostProcessor 实现（示例）
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        // 基于 XML 资源 BeanDefinitionReader 实现
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        // 加载Properties资源
        // 指定字符编码 UTF-8
        String[] locations = {"META-INF/dependency-lookup-context.xml", "META-INF/bean-constructor-dependency-injection.xml"};

        int beanNumbers = beanDefinitionReader.loadBeanDefinitions(locations);

        System.out.println("已经加载的 BeanDefinition 数量： " + beanNumbers);

        // 通过 Bean Id 和 类型 进行依赖查找
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
        User superUser = beanFactory.getBean("superUser", User.class);
        System.out.println(superUser);

        // 构造器注入，按照类型注入， resolveDependency
        UserHolder userHolder = beanFactory.getBean("userHolder", UserHolder.class);
        System.out.println(userHolder);
    }

    static class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            if (ObjectUtils.nullSafeEquals("superUser", beanName) && SuperUser.class.equals(beanClass)) {
                // 把配置完成好的 superUser Bean 覆盖掉
                return new SuperUser();
            }
            // 保持 Spring 容器默认实现
            return null;
        }
    }
}

