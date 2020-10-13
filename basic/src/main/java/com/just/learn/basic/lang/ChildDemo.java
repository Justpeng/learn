package com.just.learn.basic.lang;

public class ChildDemo extends ParentDemo {

    private Integer age;

    public ChildDemo(String name,Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 子类异常范围小于等于父类
     * 返回类型返回小于等于父类
     * 访问修饰符大于等于父类
     * @return
     * @throws RuntimeException
     */
    @Override
    public Object wrapName() throws RuntimeException {
        return "child" + getName();
    }

}
