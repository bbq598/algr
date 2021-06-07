import java.util.*;

public class TwoSumUniquepairs587 {

    public int twoSum6(int[] nums, int target){
        Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            data.put(nums[i], data.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> result = new HashSet<>();
        for (int n : data.keySet()){
            int value = target - n;
            if(data.containsKey(value)){
                if(target == value * 2){
                    if (data.get(value) >= 2){
                        result.add(value);
                    }else{
                        continue;
                    }
                }
                result.add(Math.min(value,n));
            }
        }
        return result.size();
    }

  public static void main(String[] args) {
    int[] arr = {1,1,2,45,46,46};
    int target = 47;
    System.out.println(new TwoSumUniquepairs587().twoSum6(arr, target));
  }
}
