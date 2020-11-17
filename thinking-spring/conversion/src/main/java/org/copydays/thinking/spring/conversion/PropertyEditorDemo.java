package org.copydays.thinking.spring.conversion;

import java.beans.PropertyEditor;

/**
 * {@link PropertyEditor}
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class PropertyEditorDemo {
    public static void main(String[] args) {
        // 模拟 Spring Framework 操作

        String text = "name = rmliu";

        PropertyEditor propertyEditor = new StringToPropertyEditorDemo();
        //  传递 String 类型的内容
        propertyEditor.setAsText(text);

        System.out.println(propertyEditor.getValue());
        System.out.println(propertyEditor.getAsText());
    }
}

