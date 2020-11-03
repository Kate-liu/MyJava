package org.copydays.thinking.spring.bean.lifecyle;

import org.copydays.thinking.spring.ioc.overview.domain.SuperUser;
import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

/**
 * TODO
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("superUser", beanName) && SuperUser.class.equals(beanClass)) {
            // 把配置完成好的 superUser Bean 覆盖掉
            return new SuperUser();
        }
        // 保持 Spring 容器默认实现
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(bean.getClass())) {
            User user = (User) bean;
            user.setId(2L);
            user.setName("荣明");
            // user 对象 不允许属性赋值，（配置元信息-> 属性值）
            // 使用实例化之后的方法调用，直接跳过属性的赋值，所以对象是没有值的
            return false;
        }
        return true;
    }

    // user 对象， 跳过 Bean 属性赋值，基于上述postProcessAfterInstantiation()中的， return false;
    // superUser 对象，  跳过 Bean 实例化，不走寻常路，跳过 Bean 属性赋值
    // userHolder 对象，进行属性赋值前的操作，更改 property value
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())) {
            // 拦截 userHolder Bean 拦截
            // PropertyValues 包含一个 PropertyValue，如果使用 XML 配置，<property name="number" value="1" />
            final MutablePropertyValues propertyValues;

            if (pvs instanceof MutablePropertyValues) {
                propertyValues = (MutablePropertyValues) pvs;
            } else {
                propertyValues = new MutablePropertyValues();
            }

            // 等价于 <property name="number" value="1" />
            propertyValues.addPropertyValue("number", "1");
            // <property name="description" value="The user holder"/>
            if (propertyValues.contains("description")) {
                // PropertyValue value 是不可变的，即 private final Object value;
                PropertyValue propertyValue = propertyValues.getPropertyValue("description");
                propertyValues.removePropertyValue("description");
                propertyValues.addPropertyValue("description", "The user holder v2");
            }

            return propertyValues;
        }
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())) {

            UserHolder userHolder = (UserHolder) bean;
            userHolder.setDescription("The user holder v3");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())) {

            UserHolder userHolder = (UserHolder) bean;
            userHolder.setDescription("The user holder v7");
        }
        return bean;
    }
}

