import java.util.HashMap;
import java.util.Map;

public class FirstUniqueNumberinDataStream685 {

    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here

        if(nums == null || nums.length == 0){
            return -1;
        }

        Map<Integer, Integer> res = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            res.put(nums[i], res.getOrDefault(nums[i], 0) + 1);
            if (nums[i] == number) {
                break;
            }
        }
        if (!res.containsKey(number)) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (res.get(nums[i]) == 1) {
                return nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] n = {1, 2, 2, 1, 3, 4, 4, 5, 6};
                
    }
    
}
