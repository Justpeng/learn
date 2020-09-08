package com.just.learn.basic.algorithem;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-05-18 18:23
 **/
public class MyArray {

    private int[] array;

    private int size;

    public MyArray(int capacity){
        this.array = new int[capacity];
        this.size = 0;
    }

    public int[] insert(int index,int element){
        if(index < 0 || index > size){
            return null;
        }
        for(int i = size - 1;i>=index;i--){
            array[i+1] = array[i];
        }
        array[index-1] = element;
        size++;
        return array;
    }

    public static void main(String[] args){
        MyArray myArray = new MyArray(6);
        int[] result = myArray.insert(1,1);
        if(result == null){
            System.out.println("null");
            return;
        }
        for(int element:result){
            System.out.print(element);
        }
    }
}
