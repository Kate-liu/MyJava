package org.copydays.thinking.spring.bean.lifecyle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

/**
 * {@link DestructionAwareBeanPostProcessor} 实现
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())) {

            UserHolder userHolder = (UserHolder) bean;
            userHolder.setDescription("The user holder v9");
            System.out.println("postProcessBeforeDestruction() => " + userHolder.getDescription());
        }
    }
}

