import java.util.*;

public class LongestContinuousIncreasingSubsequenceI398 {


    static class listData{

        public int[] point;
        public int value;
        public int size = 1;

        public listData(int[] point, int value) {
            this.point = point;
            this.value = value;
        }

    }


    public int longestContinuousIncreasingSubsequence2(int[][] matrix) {
        // write your code here

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        ArrayList<listData> data = new ArrayList<>();
        Map<String, listData> hashData = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int[] n = {i, j};
                listData listData = new listData(n, matrix[i][j]);
                data.add(listData);
                hashData.put(i + " " + j, listData);
            }
        }

        data.sort(new Comparator<listData>() {
            @Override
            public int compare(listData o1, listData o2) {
                return o1.value - o2.value;
            }
        });

        int m = 0;
        int[] moveX = {0, 0, 1, -1};
        int[] moveY = {1, -1, 0, 0};

        for (int i = 0; i < data.size(); i++) {
            listData listData = data.get(i);
            int x = listData.point[0];
            int y = listData.point[1];
            for (int j = 0; j < moveX.length; j++) {
                int newX = x + moveX[j];
                int newY = y + moveY[j];
                if (newX < 0 || newX >= matrix.length) {
                    continue;
                }
                if (newY < 0 || newY >= matrix[0].length) {
                    continue;
                }
                String newsize = newX + " " +  newY;
                listData otherData = hashData.get(newsize);
                if (otherData.value < listData.value) {
                    listData.size = Math.max(listData.size, otherData.size + 1);
                    m = Math.max(listData.size, m);
                }
            }
        }

        return m;
    }


    public static void main(String[] args) {

        int[][] list = {
                {1, 2, 3, 4, 5},
                {16, 17, 24, 23, 6},
                {15, 18, 25, 22, 7},
                {14, 19, 20, 21, 8},
                {13, 12, 11, 10, 9},
    };
        int[][] list2 = {{1}};

        LongestContinuousIncreasingSubsequenceI398 l = new LongestContinuousIncreasingSubsequenceI398();
        System.out.println(l.longestContinuousIncreasingSubsequence2(list2));

    }

}
