package org.copydays.thinking.java.jvm.core.technology.classload;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class JvmAppClassLoaderAddURL {
    public static void main(String[] args) {
        String  appPath = "file:/d:/app";

        URLClassLoader urlClassLoader = (URLClassLoader) JvmAppClassLoaderAddURL.class.getClassLoader();
        try {
            Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            addURL.setAccessible(true);
            URL url = new URL(appPath);
            addURL.invoke(urlClassLoader, url);
            // 下面的书写，效果等于 Class.forName("org.copydays.thinking.java.jvm.core.technology.classload.Hello").newInstance();
            Class.forName("org.copydays.thinking.java.jvm.core.technology.classload.Hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
