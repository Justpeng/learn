package classic;

public class Solution04 {

    public int part(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (k == nums[mid]) {
                return mid;
            }
            if (k > nums[mid]) {
                left =mid+1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution04 solution04 = new Solution04();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(solution04.part(nums, 3));

    }
}
