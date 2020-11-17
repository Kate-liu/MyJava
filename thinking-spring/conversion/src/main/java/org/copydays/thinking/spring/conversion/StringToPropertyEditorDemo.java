package org.copydays.thinking.spring.conversion;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.Properties;

/**
 * TODO
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @see PropertyEditor
 * @since
 */
public class StringToPropertyEditorDemo extends PropertyEditorSupport implements PropertyEditor {

    // 实现 setAsText(String text)
    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        // 将String 类型转换成 Properties
        Properties properties = new Properties();

        try {
            properties.load(new StringReader(text));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 临时存储 Properties 对象
        setValue(properties);

        // next, 获取 Properties 对象 #getValue()
    }

    @Override
    public String getAsText() {
        Properties properties = (Properties) getValue();
        StringBuilder textBuilder = new StringBuilder();

        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            textBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append(System.getProperty("line.separator"));
        }

        return textBuilder.toString();
    }
}

