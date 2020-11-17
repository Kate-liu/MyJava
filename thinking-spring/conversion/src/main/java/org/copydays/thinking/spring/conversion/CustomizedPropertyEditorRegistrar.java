package org.copydays.thinking.spring.conversion;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * {@link PropertyEditorRegistrar} 自定义实现
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @see PropertyEditorRegistrar
 * @since
 */
// @Component  // 3.将其声明为 Spring Bean
public class CustomizedPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        // 1.通用类型转换
        // 2.针对 Java Bean 属性类型转换
        registry.registerCustomEditor(User.class, "context", new StringToPropertyEditorDemo());

    }
}

