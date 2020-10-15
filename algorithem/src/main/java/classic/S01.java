package classic;

public class S01 {
    public static int rabbit(int n) {
        if (n == 0) {
            return 0;
        }

        int count = countRabbit(n);
        return count;
    }

    private static int countRabbit(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return countRabbit(n - 1) + countRabbit(n - 2);
    }

    public static void main(String[] args) {
//        System.out.println("3个月后兔子:" + rabbit(3));
//        System.out.println("30个月后兔子:" + rabbit(30));

        System.out.println(100000/10);
    }
}
