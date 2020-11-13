package org.copydays.thinking.spring.validation;


import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.context.MessageSource;
import org.springframework.validation.*;

import java.util.Locale;

import static org.copydays.thinking.spring.validation.ErrorMessageDemo.createMessageSource;

/**
 * 自定义 Spring {@link Validator} 实现
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @see Validator
 * @since
 */
public class ValidatorDemo {
    public static void main(String[] args) {
        // 创建 Validator
        Validator validator = new UserValidator();

        // 判断是否支持目标对象的类型
        User user = new User();
        System.out.println("user 对象是否被 UserValidator 支持校验： " + validator.supports(user.getClass()));

        // 校验过程
        // 创建 Errors 对象
        Errors errors = new BeanPropertyBindingResult(user, "user");
        validator.validate(user, errors);

        // 获取 MessageSource 对象
        MessageSource messageSource = createMessageSource();

        // 输出所有的错误文案
        for (ObjectError error : errors.getAllErrors()) {
            String message = messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault());
            System.out.println(message);
        }
    }

    static class UserValidator implements Validator {

        @Override
        public boolean supports(Class<?> clazz) {
            return User.class.isAssignableFrom(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            User user = (User) target;

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");

            String userName = user.getName();
            // ...

        }
    }
}

