package org.copydays.thinking.spring.bean.factory;

import org.copydays.thinking.spring.ioc.overview.domain.User;

/**
 * {@link User} 工厂模式 工厂类
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public interface UserFactoryInterface {
    // 编译级别是 Java5，则会飘红
    // 默认maven版本是1.5
    // java8 之后，没有绝对的抽象类实现，会有默认实现
    default User createUser() {
        return User.createUser();
    }
}
