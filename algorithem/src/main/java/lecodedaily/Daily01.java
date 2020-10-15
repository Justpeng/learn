package lecodedaily;

public class Daily01 {
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

    public static void main(String[] args) {
        System.out.println(reverse(3212));
    }
}

