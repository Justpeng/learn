package com.just.learn.basic.lang;

import java.util.concurrent.ConcurrentHashMap;

public class ParentDemo {
    /**
     * 子类拥有父类非private 属性和方法
     */
    public String name;

    /**
     * 不可被继承
     */
    private String address;

    /**
     * 子类在执行构造方法前，如果没有用super()来调用父类特定的构造方法，
     * 则会调用父类中'没有参数的构造方法'
     *
     * 如果父类没有无参构造方法，就会便易出错
     */
    public ParentDemo() {

    }

    public ParentDemo(String name) {
        this.name = name;
    }

    protected Object wrapName() throws Exception {
        return "name:" + name;
    }

    /**
     * 不可被继承
     * @return
     */
    private Character getFistName() {
        return name.charAt(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
