package org.copydays.thinking.spring.bean.lifecyle;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * User Holder
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class UserHolder implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, EnvironmentAware,
        InitializingBean, SmartInitializingSingleton, DisposableBean {

    private final User user;

    private Integer Number;

    private String description;

    private ClassLoader classLoader;
    private BeanFactory beanFactory;
    private String beanName;
    private Environment environment;

    public User getUser() {
        return user;
    }

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    public UserHolder(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @PostConstruct
    public void initPostConstruct() {
        this.description = "The user holder V4";
        System.out.println("initPostConstruct() => " + description);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.description = "The user holder V5";
        System.out.println("afterPropertiesSet() => " + description);
    }

    public void init() {
        this.description = "The user holder V6";
        System.out.println("init() => " + description);
    }

    @Override
    public void afterSingletonsInstantiated() {
        this.description = "The user holder V8";
        System.out.println("afterSingletonsInstantiated() => " + description);
    }

    @PreDestroy
    public void preDestroy() {
        this.description = "The user holder V10";
        System.out.println("preDestroy() => " + description);
    }

    @Override
    public void destroy() throws Exception {
        this.description = "The user holder V11";
        System.out.println("destroy() => " + description);
    }

    public void doDestroy() {
        this.description = "The user holder V12";
        System.out.println("doDestroy() => " + description);
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                ", Number=" + Number +
                ", description='" + description + '\'' +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    // BeanNameAware, BeanClassLoaderAware, BeanFactoryAware 可以直接在 BeanFactory 中回调
    // EnvironmentAware 和后续的 Aware 只能在 ApplicationContext 中回调
    // 具体见 @see  org.copydays.thinking.spring.bean.lifecyle.InstantiationLifecyleDemo

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = beanName;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    protected void finalize() throws Throwable {
        System.out.println("userHolder is finalized...");
    }
}

