package org.copydays.thinking.java.jvm.core.technology.classload;

import java.util.Base64;

public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            new HelloClassLoader().findClass("org.copydays.thinking.java.jvm.core.technology.classload.Hello").newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 实验失败
        // 原因：无法提取出准确的二进制数据，将其转为 base64 编码数据
        // 在线 Base64 编码网址：
        String helloBase64 = "cGFja2FnZSBvcmcuY29weWRheXMudGhpbmtpbmcuamF2YS5qdm0uY29yZS50ZWNobm9sb2d5LmNsYXNzbG9hZDsKCnB1YmxpYyBjbGFzcyBIZWxsbyB7CiAgICBzdGF0aWMgewogICAgICAgIFN5c3RlbS5vdXQucHJpbnRsbigiSGVsbG8gQ2xhc3MgSW5pdGlhbGl6ZWQhIik7CiAgICB9Cn0=";

        byte[] bytes = decode(helloBase64);
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] decode(String base64) {
        return Base64.getDecoder().decode(base64);
    }
}
