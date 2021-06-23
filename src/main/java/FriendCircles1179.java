import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FriendCircles1179 {



    public int findCircleNum(int[][] M) {

        // Write your code here
        List<HashSet<Integer>> data = new ArrayList<>();
        boolean flag = false;

        for (int i = 0; i < M.length; i++) {
            flag = false;
            for (int j = 0; j < M[i].length; j++) {
                for (int k = 0; k < data.size(); k++) {
                    if (data.get(i).contains(M[i][j])) {

                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] M = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

    }



}
