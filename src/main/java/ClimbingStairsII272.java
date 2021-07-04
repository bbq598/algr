import java.util.*;

public class ClimbingStairsII272 {


    public int climbStairs2(int n) {
        // write your code here
        if (n == 0) {
            return 1;
        }
        List<Integer> res = new ArrayList<>();
        res.add(0);
        Map<Integer, Integer> data = new HashMap<>();

        int n1 = find(n, data);
        return n1;
    }

    private int find(int n, Map<Integer, Integer> data) {

        if (n == 1 || n == 0) {
            return 1;
        }
        if (n  == 2 ) {
            return 2;
        }
        if (data.containsKey(n)) {
            return data.get(n);
        }

        int num = find(n - 1, data) + find(n - 2, data) + find(n - 3, data);
        data.put(n, num);
        return num;
    }

    public static void main(String[] args) {
        ClimbingStairsII272 c = new ClimbingStairsII272();
        int n = 3;
        System.out.println(c.climbStairs2(n));
    }
}
