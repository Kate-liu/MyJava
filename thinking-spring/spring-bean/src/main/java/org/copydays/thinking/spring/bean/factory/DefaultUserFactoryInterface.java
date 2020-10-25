package org.copydays.thinking.spring.bean.factory;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLOutput;

/**
 * 默认 {@link UserFactoryInterface} 实现
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class DefaultUserFactoryInterface implements UserFactoryInterface, InitializingBean, DisposableBean {

    // 初始化
    // 1.基于 @PostConstruct 注解
    // 顺序：第一
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct： User Factory 初始化中...");
    }

    // 2.基于 @Bean(initMethod = "initUserFactory") 的 Java 注解实现
    // 顺序：第三
    public void initUserFactory() {
        System.out.println("自定义初始化方法 initUserFactory()： User Factory 初始化中...");
    }

    // 3.基于 InitializingBean 接口 的 afterPropertiesSet() 方法实现
    // 顺序：第二
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet()： User Factory 初始化中...");
    }

    // 销毁
    // 1.基于 @PreDestroy 注解
    // 顺序：第一
    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy： User Factory 销毁中...");
    }

    // 2.基于 DisposableBean 接口 的 destroy() 方法实现
    // 顺序：第二
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean#destroy()： User Factory 销毁中...");
    }

    // 3.基于 @Bean(destroyMethod = "doDestroy") 的 Java 注解实现
    // 顺序：第三
    public void doDestroy() {
        System.out.println("自定义销毁方法 doDestroy()： User Factory 销毁中...");

    }

    // 回收
    // 覆盖 Object 类中的 finalize() 方法
    @Override
    protected void finalize() throws Throwable {
        System.out.println("当前 Default UserFactory Interface 对象正在被垃圾回收...");
    }
}

