import java.util.Arrays;

public class TwoumDifferenceequalstarget610 {

    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        int j = 1;

        target = Math.abs(target);
        for (int i = 0; i < nums.length; i++) {
            j = j == i ? j + 1 : j;
            while (j < nums.length && nums[j] - nums[i] < target) {
                j++;
            }
            if (j == nums.length) {
                break;
            }
            if (nums[j] - nums[i] == target) {
                return new int[]{nums[i], nums[j]};
            }
        }


        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {0, 5, 7};
        int target = -2;
        TwoumDifferenceequalstarget610 t = new TwoumDifferenceequalstarget610();
        System.out.println(Arrays.toString(t.twoSum7(nums, target)));
    }
}
