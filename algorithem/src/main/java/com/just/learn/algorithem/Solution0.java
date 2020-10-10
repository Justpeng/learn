package com.just.learn.algorithem;

import com.alibaba.fastjson.JSONObject;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution0 {
    /**
     * 利用最大堆
     * @param input
     * @param k
     * @return
     */
    public static int[] getLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0) {
            return null;
        }
        if (k > input.length) {
            return input;
        }
        int[] result = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparing(f -> f.intValue()));
        for (int value : input) {
            queue.add(value);
        }
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }


    public static void main(String[] args) {
        int[] test = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(JSONObject.toJSONString(getLeastNumbers_Solution(test, 4)));
    }
}
