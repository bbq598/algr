import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraySum138 {

    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        if (nums == null) {
            return null;
        }
        Map<Integer, Integer> data = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                result.add(0);
                result.add(i);
                break;
            }
            if (data.containsKey(sum)) {
                int n = data.get(sum) + 1;
                result.add(n);
                result.add(i);
                break;
            }else{
                data.put(sum, i);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {-3, 1, 2, - 3, 4};
        SubarraySum138 s = new SubarraySum138();
        s.subarraySum(nums);
    }


}
