package org.copydays.thinking.spring.resource;

import org.copydays.thinking.spring.resource.util.ResourceUtils;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;


/**
 * 自定义 {@link ResourcePatternResolver}
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @see ResourcePatternResolver
 * @see PathMatchingResourcePatternResolver
 * @see PathMatcher
 * @since
 */
public class CustomizedResourcePatternResolverDemo {
    public static void main(String[] args) throws IOException {
        // 读取当前 package 路径下的所有 *.java 文件
        String currentPackagePath = "/" + System.getProperty("user.dir") + "/thinking-spring/resource/src/main/java/org/copydays/thinking/spring/resource/";

        String locationPattern = currentPackagePath + "*.java";

        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());
        // 使用 PathMatcher
        resourcePatternResolver.setPathMatcher(new JavaFilePathMatcher());

        Resource[] resources = resourcePatternResolver.getResources(locationPattern);

        Stream.of(resources).map(ResourceUtils::getContent).forEach(System.out::println);

    }

    static class JavaFilePathMatcher implements PathMatcher {

        @Override
        public boolean isPattern(String path) {
            return path.endsWith(".java");
        }

        @Override
        public boolean match(String pattern, String path) {
            return path.endsWith(".java");
        }

        @Override
        public boolean matchStart(String pattern, String path) {
            return false;
        }

        @Override
        public String extractPathWithinPattern(String pattern, String path) {
            return null;
        }

        @Override
        public Map<String, String> extractUriTemplateVariables(String pattern, String path) {
            return null;
        }

        @Override
        public Comparator<String> getPatternComparator(String path) {
            return null;
        }

        @Override
        public String combine(String pattern1, String pattern2) {
            return null;
        }
    }
}

