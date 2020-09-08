package com.just.learn.basic.jvm;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-05-21 09:46
 **/
public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        throw new ClassNotFoundException(name);
    }
}
