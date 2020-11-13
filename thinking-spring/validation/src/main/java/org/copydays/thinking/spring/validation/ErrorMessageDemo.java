package org.copydays.thinking.spring.validation;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Locale;

/**
 * 错误文案输出示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @see Errors
 * @since
 */
public class ErrorMessageDemo {
    public static void main(String[] args) {
        // 创建 User 对象
        User user = new User();
        user.setName("rmliu");

        // 选择 Errors 实现, BeanPropertyBindingResult
        Errors errors = new BeanPropertyBindingResult(user, "user");

        // 调用 reject or rejectValue 方法
        // reject 生成 ObjectError
        // rejectValue 生成 FieldError
        errors.reject("user.properties.not.null");
        // user.name = user.getName()
        errors.rejectValue("name", "name.required");

        // 获取 Errors 中 ObjectError 或者 FieldError
        List<ObjectError> globalErrors = errors.getGlobalErrors();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        List<ObjectError> allErrors = errors.getAllErrors();

        // 通过  ObjectError 或者 FieldError 中的 code 和 args 来关联 MessageSource 实现
        MessageSource messageSource = createMessageSource();

        for (ObjectError error : allErrors) {
            String message = messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault());
            System.out.println(message);
        }

    }

    static MessageSource createMessageSource() {
        StaticMessageSource messageSource = new StaticMessageSource();
        messageSource.addMessage("user.properties.not.null", Locale.getDefault(), "The name of user properties must not null!");
        messageSource.addMessage("name.required", Locale.getDefault(), "The name of user must not null!");
        messageSource.addMessage("id.required", Locale.getDefault(), "The id of user must not null!");
        return messageSource;

    }
}

