package lecodedaily;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Week01 {
    /**
     * 翻转正数
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if (ans > 214748364 || ans < -214748364) {
                return 0;
            }
            //ans每次乘10高位进1，x取模取个位
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }

    /**
     * 两数相加
     * @param array
     * @param target
     * @return
     */
    public int[] twoSum(int[] array, int target) {
        int n = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - array[i])) {
                return new int[]{i, map.get(target - array[i])};
            }
            map.put(array[i], i);
        }
        return new int[0];
    }

    /**
     * 9 是否回文
     * @param x
     * @return
     */
    public boolean isPalindrome(String x) {
        if(x==null){
            return false;
        }
        if (x.length() == 1) {
            return true;
        }
        char[] c = x.toCharArray();
        int i = 0, j = c.length - 1;
        while (i < j) {
            if (c[i] != c[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        //x < 0 不是回文，末尾是0 不是回文
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        //x=0是回文
        if (x == 0) {
            return true;
        }
        int reverseNumber = 0;
        while (x > reverseNumber) {
            reverseNumber = reverseNumber * 10 + x % 10;
            x = x / 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == reverseNumber || x == reverseNumber / 10;

    }

    public static void main(String[] args) {
        System.out.println(123 / 10);
        System.out.println();
    }
}

