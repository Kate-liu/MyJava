package org.copydays.thinking.spring.bean.factory;

import org.copydays.thinking.spring.ioc.overview.domain.User;

/**
 * {@link User} 具体工厂类
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class UserFactory {
    public User createUser() {
        return User.createUser();
    }

}

