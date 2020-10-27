package org.copydays.thinking.spring.dependency.injection.annotation;

import java.lang.annotation.*;

/**
 * 自定义的依赖注入的 注解，仅关注于 User
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectedUser {
}
