public class Backpack92 {

    public int backPack(int m, int[] A) {
        // write your code here

        boolean[][] data = new boolean[A.length + 1][m + 1];

        data[0][0] = true;

        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (j >= A[i - 1]) {
                    data[i][j] = data[i - 1][j]  || data[i - 1][j - A[i - 1]];
                }else{
                    data[i][j] = data[i - 1][j ];
                }
            }
        }


        for (int i = data[0].length - 1; i >= 0; i--) {
            if (data[A.length][i]) {
                return i;
            }
        }
        return -1;
    }


    public int backPack2(int m, int[] A) {

        int[][] data = new int[A.length + 1][m + 1];

        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (j >= A[i - 1]) {
                    data[i][j] = Math.max(data[i - 1][j], data[i - 1][j - A[i - 1]] + A[i -1 ]);
                }else {
                    data[i][j] = data[i - 1][j];
                }
            }
        }

        return data[data.length - 1][data[0].length - 1];

    }


    public static void main(String[] args) {
        int m = 10;
        int[] A = {3, 4, 8, 5};
        Backpack92 b = new Backpack92();
        System.out.println(b.backPack2(m, A));
    }


}
