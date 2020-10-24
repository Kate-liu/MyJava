package org.copydays.thinking.spring.bean.definition;

import org.copydays.thinking.spring.bean.factory.UserFactoryInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean 垃圾回收
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class BeanGarbageCollectionDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class （配置类）
        applicationContext.register(BeanInitializationDemo.class);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 关闭 Spring 应用上下文
        applicationContext.close();

        Thread.sleep(5000L);
        // 强制触发 GC, 有的时候不能被 GC，需要等待一些时间
        System.gc();
        Thread.sleep(5000L);


    }

}

