package org.copydays.thinking.spring.validation;

import org.copydays.thinking.spring.ioc.overview.domain.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * JavaBeans 示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class JavaBeansDemo {
    public static void main(String[] args) throws IntrospectionException {

        // stopClass 排除（截止）类
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);

        // 所有的 Java 类 均继承 java.lang.Object
        // class 属性来自于 Object#getClass()
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    propertyDescriptor.getReadMethod();// Getter 方法
                    propertyDescriptor.getWriteMethod(); // Setter 方法
                    System.out.println(propertyDescriptor);
                });

        // 输出 user 定义的方法
        Stream.of(beanInfo.getMethodDescriptors())
                .forEach(methodDescriptor -> {
                    System.out.println(methodDescriptor);
                });
    }
}

