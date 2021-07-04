public class UniquePaths114 {


    public int uniquePaths(int m, int n) {
        // write your code here

        int[][] graph = new int[m][n];

        for (int i = 0; i < n; i++) {
            graph[0][i] =1;
        }

        for (int i = 0; i < m; i++) {
            graph[i][0] = 1;
        }

        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph[i].length; j++) {

                graph[i][j] = graph[i][j - 1] + graph[i - 1][j];
            }
        }

        return graph[m - 1][n - 1];

    }




    public static void main(String[] args) {
        int m = 3;
        int n = 1;
        UniquePaths114 u = new UniquePaths114();
        System.out.println(u.uniquePaths(m, n));
    }

}
