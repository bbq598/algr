public class LongestIncreasingSubsequence76 {


    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    m = Math.max(m, dp[i]);
                }
            }

        }
        return m + 1;
    }


    public static void main(String[] args) {

        int[] nums = {5, 4, 1, 2, 3};
        LongestIncreasingSubsequence76 l = new LongestIncreasingSubsequence76();
        System.out.println(l.longestIncreasingSubsequence(nums));

    }


}
