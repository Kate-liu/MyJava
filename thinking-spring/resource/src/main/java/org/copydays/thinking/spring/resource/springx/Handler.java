package org.copydays.thinking.spring.resource.springx;


import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * 简单继承 {@link sun.net.www.protocol.x.Handler} 类
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class Handler extends sun.net.www.protocol.x.Handler {
    // -Djava.protocol.handler.pkgs=org.copydays.thinking.spring.resource
    public static void main(String[] args) throws IOException {
        // springx 协议
        URL url = new URL("springx:///META-INF/production.properties");
        InputStream inputStream = url.openStream();  // 类似于 Spring  中 classpath:/META-INF/default.properties

        System.out.println(StreamUtils.copyToString(inputStream, Charset.forName("utf-8")));

    }
}

