package com.just.learn.basic.algorithem;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {11,1,2,3,5,7,8,9,10};
        bubbleSortMethod(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] bubbleSortMethod(int[] arr) {
        // 对 arr 进行拷贝，不改变参数内容
        for (int i = 0; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            for (int j = 0; j < arr.length -1- i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
}
