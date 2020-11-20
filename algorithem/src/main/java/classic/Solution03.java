package classic;

import java.util.Random;

public class Solution03 {

    private static final int INSERTION_SORT_THRESHOLD = 7;
    private static final Random RANDOM = new Random();

    /**
     * 快速排序
     * 基本思路：快速排序每一次都排定一个元素（这个元素呆在了它最终应该呆的位置），然后递归地去排它左边的部分和右边的部分，依次进行下去，直到数组有序；
     * 分而治之,
     * 写对「快速排序」的技巧：保持「循环不变量」，即定义的变量在循环开始前、循环过程中、循环结束以后，都保持不变的性质，这个性质是人为根据问题特点定义的。
     * @param nums
     * @return
     */
    public int[] quickSort(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (right - left < INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }
        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex);
        quickSort(nums, pIndex + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int lt = left;
        // 循环不变量 all in [left+1,lt] < pivot
        // all in [lt+1,i] >=pivot
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums,left,lt);
        return lt;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j-1];
                j--;
            }
            nums[i] = temp;
        }
    }
}
