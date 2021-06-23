import java.util.*;

public class CombinationSum135 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here

        Set<List<Integer>> res = new HashSet<>();
        find(candidates, target, new ArrayList<>(), res);

        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> l : res) {
            list.add(l);
        }
        return list;
    }

    private void find(int[] candidates, int target, List<Integer> path, Set<List<Integer>> res) {

        if (target == 0) {
            List<Integer> list = new ArrayList<>(path);
            list.sort(Comparator.naturalOrder());
            res.add(list);
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            path.add(candidates[i]);
            find(candidates, target - candidates[i], path, res);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] n = {2, 3, 6, 7};
        int target = 7;
        CombinationSum135 c = new CombinationSum135();
        c.combinationSum(n, target);



    }



}
