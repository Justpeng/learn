package com.just.learn.basic.algorithem;

public class BinaraySearch {

    public static void main(String []args) {
        int[] arr = {0,1,2,3,5,7,8,9,10};
        int index = getIndex(arr,7);
        System.out.println(index);

    }

    public static int getIndex(int arr[],int key){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid  = (high+low)/2;
            int midValue = arr[mid];
            if(midValue == key){
                return mid;
            }else if(midValue>key){
                high = mid--;
            }else if(midValue<key){
                low = mid++;
            }
        }
        return -1;
    }


}
