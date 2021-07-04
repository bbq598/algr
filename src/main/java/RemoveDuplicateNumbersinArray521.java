import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNumbersinArray521 {

    public int deduplication(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int j = 1;
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            j = Math.max(j, i + 1);
            m = i;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            if (j >= nums.length) {
                break;
            }
            int temp = nums[i + 1];
            nums[i + 1] = nums[j];
            nums[j] = temp;
            j++;
        }
        return m + 1;
    }

    public int deduplication2(int[] nums) {

        Set<Integer> data = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            data.add(nums[i]);
        }
        int n = 0;
        for (int i : data) {
            nums[n] = i;
            n++;
        }
        return data.size();

    }


        public static void main(String[] args) {
        int[] nums = {1, 3, 1, 4, 4, 2};
        RemoveDuplicateNumbersinArray521 r = new RemoveDuplicateNumbersinArray521();
        System.out.println(r.deduplication(nums));
        System.out.println(Arrays.toString(nums));

    }

}
