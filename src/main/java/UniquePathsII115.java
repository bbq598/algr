public class UniquePathsII115 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here

        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return -1;
        }
        int[][] res = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < obstacleGrid.length; i++) {

            if (obstacleGrid[i][0] == 1) {
                break;
            }
            res[i][0] = 1;
        }

        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            res[0][i] = 1;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }

        return res[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        UniquePathsII115 u = new UniquePathsII115();
        int[][] data = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(u.uniquePathsWithObstacles(data));

    }
}
