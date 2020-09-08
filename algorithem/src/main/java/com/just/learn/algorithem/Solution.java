package com.just.learn.algorithem;

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
    }
}
