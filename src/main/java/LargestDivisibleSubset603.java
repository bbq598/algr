import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset603 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        // write your code here

        if (nums == null || nums.length == 0) {
            return null;
        }

        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] data = new int[nums.length];
        dp[0] = 0;
        data[0] = -1;
        int m = 0;
        for (int i = 1; i < nums.length; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                int n = nums[i];
                int a = nums[j];
                if (n % a == 0) {
                    if (max < dp[j] + 1) {
                        max = dp[j] + 1 ;
                        dp[i] = max;
                        data[i] = j;
                        m = Math.max(m, max);
                    }
                }
            }
            if (max == -1) {
                dp[i] = 0;
                data[i] = -1;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i] == m) {
                int b = i;
                while (b != -1) {
                    res.add(0,nums[b]);
                    b = data[b];
                }
                break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        LargestDivisibleSubset603 l = new LargestDivisibleSubset603();
        int[] nums = {1,2,4,8};
        System.out.println(l.largestDivisibleSubset(nums).toString());
    }

}
