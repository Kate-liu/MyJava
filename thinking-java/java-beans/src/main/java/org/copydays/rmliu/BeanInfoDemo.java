package org.copydays.rmliu;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * {@link BeanInfo} 示例
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    System.out.println(propertyDescriptor);
                    // show property and method,
                    // if not StopClass the they can output class, This is one of the Object class getClass method

                    // propertyDescriptor 允许添加属性编辑器 - PropertyEditor
                    // GUI程序， text(String) ->PropertyType
                    // name -> String
                    // age -> Integer
                    Class<?> propertyType = propertyDescriptor.getPropertyType();

                    String propertyName = propertyDescriptor.getName();
                    if ("age".equals(propertyName)) { // 为"age"字段(属性)添加PropertyEditor
//                        String -> Integer
//                        Integer.valueOf("1");

                        propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
//                        propertyDescriptor.createPropertyEditor() // 传入对应的beans
                        // 待完成
                    }
                });
    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);

        }
    }
}
