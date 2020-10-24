package org.copydays.thinking.spring.bean.definition;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 别名示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/Bean-definition-context.xml");

        // 通过别名 rmliu 获取曾用名 user 的 Bean
        User user = beanFactory.getBean("user", User.class);
        User rmliuUser = beanFactory.getBean("rmliu", User.class);

        System.out.println("user == rmliuUser?" + (user == rmliuUser));


    }
}

