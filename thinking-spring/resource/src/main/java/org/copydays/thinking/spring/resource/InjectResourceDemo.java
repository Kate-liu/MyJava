package org.copydays.thinking.spring.resource;

import org.copydays.thinking.spring.resource.util.ResourceUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;

/**
 * 注入 {@link Resource} 示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @see Resource
 * @see Value
 * @see AnnotationConfigApplicationContext
 * @since
 */
public class InjectResourceDemo {

    @Value("classpath:/META-INF/default.properties")
    private Resource resource;

    @Value("classpath*:/META-INF/*.properties")
    private Resource[] resources;

    @Value("${user.dir}")
    private String currentDir;

    @PostConstruct
    public void init() {
        System.out.println(ResourceUtils.getContent(resource));
        System.out.println("========================");
        Stream.of(resources).map(ResourceUtils::getContent).forEach(System.out::println);
        System.out.println("========================");
        System.out.println(currentDir);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(InjectResourceDemo.class);

        context.refresh();
        context.close();
    }
}

