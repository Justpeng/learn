package com.just.learn.basic.copy;

public class PersonTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        // clone是Object方法，protected 不能访问
        Person person1 = (Person) person.clone();
    }
}
