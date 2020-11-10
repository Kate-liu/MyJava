package sun.net.www.protocol.x;

import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * X Handler 测试示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class HandlerTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("x:///META-INF/default.properties");
        InputStream inputStream = url.openStream();  // 类似于 Spring  中 classpath:/META-INF/default.properties

        System.out.println(StreamUtils.copyToString(inputStream, Charset.forName("utf-8")));

    }
}

