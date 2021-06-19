import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations15 {

    public List<List<Integer>> permute(int[] nums) {
        // write your code here

        if (nums == null) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();

        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }

        boolean[] visit = new boolean[nums.length];

        Arrays.sort(nums);
        find(nums, visit, new ArrayList<>(), res);

        return res;

    }

    private void find(int[] nums, boolean[] visit, List<Integer>path, List<List<Integer>> res) {

        if (nums.length == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) {
                continue;
            }

            path.add(nums[i]);
            visit[i] = true;
            find(nums, visit, path, res);
            visit[i] = false;
            path.remove(path.size() - 1);
        }


    }





    public static void main(String[] args) {
        int[] nums = {1,2,3};

        Permutations15 p = new Permutations15();


        p.permute(nums);


    }

}
