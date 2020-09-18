package com.just.learn.algorithem;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态规划
 * @author lipeng
 */
public class Solution {
    /**
     * 爬楼梯
     * @param n 正整数
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 最终答案： max(dp[0],dp[1],...,dp[i-1],dp[i])
     * @param nums 整数数组
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = max(dp[i - 1] + nums[i], nums[i]);
            result = max(dp[i], result);
        }
        return result;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * 三角形最短路径
     * @param triangle
     * @return
     */
    public static int miniNumTotal(int[][] triangle) {
        //长度判断
        int len = triangle.length;
        if (len < 1) {
            return 0;
        }
        if (len == 1) {
            return triangle[0][0];
        }
        int result = Integer.MAX_VALUE;

        //特殊赋值
        triangle[1][0] = triangle[0][0] + triangle[1][0];
        triangle[1][1] = triangle[0][0] + triangle[1][1];
        for (int i = 2; i < len; i++) {
            //第 i 列
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    //改列第一个
                    triangle[i][j] = triangle[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    //改列最后一个
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i][j];
                }else {
                    triangle[i][j] = min(triangle[i - 1][j - 1], triangle[i - 1][j]) + triangle[i][j];
                }
            }
        }
        for (int k = 0; k < triangle[len - 1].length; k++) {
            result = min(result, triangle[len - 1][k]);
        }
        return result;
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        Integer[][] triangle2 = new Integer[triangle.size()][];
        for (int i = 0; i < triangle.size(); i++) {
            triangle2[i] = triangle.get(i).toArray(new Integer[triangle.get(i).size()]);
        }

        int result = Integer.MAX_VALUE;
        triangle2[1][0] = triangle2[0][0] + triangle2[1][0];
        triangle2[1][1] = triangle2[0][0] + triangle2[1][1];
        for (int i = 2; i < triangle2.length; i++) {
            int row = triangle2[i].length;
            for (int j = 0; j < row; j++) {
                if (j == 0) {
                    triangle2[i][j] = triangle2[i - 1][0] + triangle2[i][j];
                } else if (j == (row - 1)) {
                    triangle2[i][j] = triangle2[i - 1][j - 1] + triangle2[i][j];
                } else {
                    triangle2[i][j] = min(triangle2[i - 1][j - 1], triangle2[i - 1][j]) + triangle2[i][j];
                }
            }
        }
        for (int k = 0; k < triangle2[triangle2.length - 1].length; k++) {
            result = min(result, triangle2[triangle2.length - 1][k]);
        }
        return result;
    }


    private static int min(int a, int b) {
        return a > b ? b : a;
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(4));

        int[] arr = {-1, 2, 3, 1, 3};
        System.out.println(maxSubArray(arr));

        int[] arr1 = new int[2];
        int[] arr2 = {1};
        int[] arr3 = new int[]{1, 2, 3};
        System.out.println(arr1[0]);
        System.out.println(arr2[0]);
        System.out.println(arr3[0]);

        //[[2],[3,4],[6,5,7],[4,1,8,3]]
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        List<List<Integer>> list5 = new ArrayList<>();
        list1.add(2);

        list2.add(3);
        list2.add(4);

        list3.add(6);
        list3.add(5);
        list3.add(7);

        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list5.add(list1);
        list5.add(list2);
        list5.add(list3);
        list5.add(list4);

        System.out.println(minimumTotal(list5));

    }
}
