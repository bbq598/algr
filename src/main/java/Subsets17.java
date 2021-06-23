import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets17 {


    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        if (nums == null) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        find(nums, 0, res, new ArrayList<>());

        return res;
    }

    private void find(int[] nums, int index, List<List<Integer>> res, List<Integer> path) {


        res.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            find(nums, i+1, res, path);
            path.remove(path.size() - 1);
        }


    }


    public List<List<Integer>> subsets2(int[] nums) {
        // write your code here
        if (nums == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        find2(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void find2(int[] nums, int index, List<List<Integer>> res, List<Integer> path) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[index]);

        find2(nums, index + 1, res, path);
        path.remove(path.size() - 1);
        find2(nums, index + 1, res, path);
    }





    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets17 s = new Subsets17();
        s.subsets2(nums);

    }
}
