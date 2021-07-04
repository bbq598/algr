public class UglyNumberII4 {


    public int nthUglyNumber(int n) {
        // write your code here

        int two = 0;
        int three = 0;
        int five = 0;

        int[] data = new int[n];
        data[0] = 1;

        for (int i = 1; i < data.length; i++) {
            data[i] = Math.min(Math.min(data[two] * 2, data[three] * 3),data[five] * 5);

            if (data[i] == data[two] * 2) {
                two++;
            }

            if (data[i] == data[three] * 3) {
                three++;
            }
            if (data[i] == data[five] * 5) {
                five++;
            }
        }

        return data[n - 1];
    }























    public int nthUglyNumber2(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int l2 = 0, l3 = 0, l5 = 0;
        for(int i = 1; i < n; ++i) {
            // 生成第i+1小的丑数
            dp[i] = Math.min(Math.min(dp[l2] * 2, dp[l3] * 3), dp[l5] * 5);
            System.out.print(dp[i] + " ");
            if (dp[i] == dp[l2] * 2) {
                ++l2;
            }
            if (dp[i] == dp[l3] * 3) {
                ++l3;
            }
            if (dp[i] == dp[l5] * 5) {
                ++l5;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 43;
        UglyNumberII4 u = new UglyNumberII4();
        System.out.println(u.nthUglyNumber(n));
        System.out.println(u.nthUglyNumber2(n));


    }
}
