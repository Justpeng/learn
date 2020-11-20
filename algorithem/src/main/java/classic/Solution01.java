package classic;

import java.util.Arrays;

/**
 * 经典排序算法
 */
public class Solution01 {

    /**
     * 思路：每一轮选取未排定的部分中最小的部分交换到未排定部分的最开头，经过若干个步骤，就能排定整个数组。
     * 即：先选出最小的，再选出第 2 小的，以此类推。
     *
     * 选择排序」看起来好像最没有用，但是如果在交换成本较高的排序任务中，就可以使用「选择排序」
     *
     * 时间复杂度：O(N^2)，这里 N 是数组的长度；
     * 空间复杂度：O(1)，使用到常数个临时变量
     * @param nums
     * @return
     */
    public int[] selectionSortArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 思路：每次将一个数字插入一个有序的数组里，成为一个长度更长的有序数组，有限次操作以后，数组整体有序。
     *
     * 插入排序：稳定排序，在接近有序的情况下，表现优异
     *
     * 时间复杂度：O(N^2)，这里 N是数组的长度；
     * 空间复杂度：O(1)，使用到常数个临时变量
     * @param nums
     * @return
     */
    public int[] insertionSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //先暂存这个元素，然后之前元素逐个后移，留出空位
            int temp = nums[i];
            int j =i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }



    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        Solution01 solution = new Solution01();
//        int[] res = solution.selectionSortArray(nums);
        int[] res = solution.insertionSort(nums);
        System.out.println(Arrays.toString(res));

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int temp = nums[i];
            int j =i;
            while (j > 0 && nums[j - 1] > nums[j]) {
                nums[j] = nums[j - 1];
            }
            nums[j-1] = temp;
        }
    }

}
