package org.copydays.thinking.spring.ioc.overview.dependency.lookup;

import org.copydays.thinking.spring.ioc.overview.annotation.Super;
import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 * 1.根据名称查找
 * 2.根据类型查找
 * 3.通过注解查找对象
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        // 3.通过注解查找对象
        lookupAnnotationType(beanFactory);

        // 2.根据类型查找
        lookupByType(beanFactory); // 根据类型查找单个对象
        lookupCollectionByType(beanFactory); // 按照类型查找集合对象

        // 1.根据名称查找
        lookupInRealTime(beanFactory); // 实时查找
        lookupInLazyTime(beanFactory); // 延迟查找
    }

    private static void lookupAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找到的所有 标注@Super 的用户集合对象：" + users);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有user集合对象：" + users);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("实时查找" + user);
    }

    private static void lookupInLazyTime(BeanFactory beanFactory) {
        // ObjectFactory 没有生成新的bean
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延时查找" + user);

    }

    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");  // 返回Object类型， 可以进行强制类型转换
        System.out.println("实时查找" + user);
    }

}

