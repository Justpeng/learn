package classic;

public class Solution02 {

    private static final int INSERTION_SORT_THRESHOLD = 7;

    /**
     * 归并排序
     * 基本思路：借助额外空间，合并两个有序数组，得到更长的有序数组
     * @param nums
     * @return
     */
    public int[] mergeSort(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
        return nums;
    }


    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (right - left < INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }
        int mid = left + (right-left)/2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        if (nums[mid] < nums[mid] + 1) {
            return;
        }

    }

    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums, left, temp, left, right + 1 - left);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            }else {
                nums[k] = temp[j];
                j++;
            }
        }
    }

    private void insertionSort(int[] nums,int left,int right) {
        for (int i = left + 1; i < right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
            }
            nums[i] = temp;
        }
    }
}
