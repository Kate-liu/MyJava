package org.copydays.thinking.spring.ioc.overview.repository;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * 用户的信息仓库
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class UserRepository {
    private Collection<User> users;  //自定义 Bean

    private BeanFactory beanFactory; // 内建非 Bean 对象（依赖）

    private ObjectFactory<ApplicationContext> objectFactory;
//    private ObjectFactory<User> userObjectFactory;

//    public ObjectFactory<User> getUserObjectFactory() {
//        return userObjectFactory;
//    }
//
//    public void setUserObjectFactory(ObjectFactory<User> userObjectFactory) {
//        this.userObjectFactory = userObjectFactory;
//    }


    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}

