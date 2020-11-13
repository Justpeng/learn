package lecodedaily;

import java.util.*;

public class Week03 {
    /**
     * 349. 两个数组的交集
      * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> n1Set = new HashSet<>();
        for (int i = 0; i < nums1.length;i++) {
            n1Set.add(nums1[i]);
        }
        Set<Integer> r = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (n1Set.contains(nums2[i])) {
                r.add(nums2[i]);
            }
        }
        int[] result = new int[r.size()];
        int i =0;
        for (int v : r) {
            result[i] = v;
            i++;
        }
        return result;
    }

    public int[] intersection2(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1Length = nums1.length;
        int n2Length = nums2.length;
        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();
        while (i < n1Length && j < n2Length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;j++;
            }else if (nums1[i] < nums2[j]){
                i++;
            }else {
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k =0;
        for (int v : set) {
            result[k] = v;
            k++;
        }
        return result;
    }
}
