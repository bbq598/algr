import java.util.ArrayList;
import java.util.List;

public class kSumII90 {

    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here

        if (A == null || A.length == 0) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();
        find(A, k, target, 0, new ArrayList<>(), res);

        return res;


    }

    private void find(int[] data, int k, int target, int index, List<Integer> path, List<List<Integer>> res) {
        if (target == 0 && k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (target < 0 || k < 0) {
            return;
        }

        for (int i = index; i < data.length; i++) {
            path.add(data[i]);
            find(data, k - 1, target - data[i], i + 1, path, res);
            path.remove(path.size() - 1);
        }

    }


    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int k = 2;
        int target = 5;
        kSumII90 kSumII90 = new kSumII90();
        kSumII90.kSumII(A, k,target );

    }


}
