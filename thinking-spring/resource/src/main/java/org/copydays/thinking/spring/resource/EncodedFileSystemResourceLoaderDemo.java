package org.copydays.thinking.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * 带有字符编码的 {@link FileSystemResourceLoader} 示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @see FileSystemResourceLoader
 * @see FileSystemResource
 * @see EncodedResource
 * @since
 */
public class EncodedFileSystemResourceLoaderDemo {
    public static void main(String[] args) throws IOException {
        String currentJavaFilePath = "/" + System.getProperty("user.dir") + "/thinking-spring/resource/src/main/java/org/copydays/thinking/spring/resource/EncodedFileSystemResourceLoaderDemo.java";

        // 创建一个 FileSystemResourceLoader 对象
        FileSystemResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();

        // FileSystemResource 是 WritableResource 也是 Resource
        Resource resource = fileSystemResourceLoader.getResource(currentJavaFilePath);

        EncodedResource encodedResource = new EncodedResource(resource, "utf-8");
        // 字符输入流
        try (Reader reader = encodedResource.getReader()) {
            System.out.println(IOUtils.toString(reader));
        }

    }
}

