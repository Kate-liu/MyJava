package org.copydays.thinking.spring.dependency.injection;

import org.copydays.thinking.spring.ioc.overview.domain.User;

/**
 * {@link User} 的 Hold 类
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class UserHolder {

    private User user;

    public UserHolder() {

    }

    public UserHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}

