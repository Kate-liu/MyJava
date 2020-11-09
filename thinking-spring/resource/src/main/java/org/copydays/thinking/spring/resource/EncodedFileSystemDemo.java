package org.copydays.thinking.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * 带有字符编码的 {@link FileSystemResource} 示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @see FileSystemResource
 * @see EncodedResource
 * @since
 */
public class EncodedFileSystemDemo {
    public static void main(String[] args) throws IOException {
        String currentJavaFilePath = System.getProperty("user.dir") + "/thinking-spring/resource/src/main/java/org/copydays/thinking/spring/resource/EncodedFileSystemDemo.java";

        File currentJavaFile = new File(currentJavaFilePath);

        // FileSystemResource 是 WritableResource 也是 Resource
        FileSystemResource fileSystemResource = new FileSystemResource(currentJavaFile);

        EncodedResource encodedResource = new EncodedResource(fileSystemResource, "utf-8");
        // 字符输入流
        try (Reader reader = encodedResource.getReader()) {
            System.out.println(IOUtils.toString(reader));
        }

    }
}

