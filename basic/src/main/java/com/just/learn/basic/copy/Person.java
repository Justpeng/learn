package com.just.learn.basic.copy;

public class Person implements Cloneable{
    private Address address;

    public Person() {

    }
    public Person(Address address) {
        this.address = new Address(address.getName());
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person)super.clone();
    }
}
