import java.util.ArrayDeque;
import java.util.Queue;

public class NumberofIslands433 {

    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }


        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    int[] root = {i, j};
                    if(isIsland(grid, root , x,y,visited)) {
                        island++;
                    }
                }
            }
        }
        return island;
    }

    private boolean isIsland(boolean[][] grid, int[] root, int[] x, int[] y, boolean[][] visited) {
        int a = root[0];
        int b = root[1];

        if(visited[a][b]){
            return false;
        }
        Queue<int[]> data = new ArrayDeque<>();
        data.offer(root);
        visited[a][b] = true;
        while (!data.isEmpty()) {
            int[] point = data.poll();
            a = point[0];
            b = point[1];
            for (int i = 0; i < x.length; i++) {
                int newX = a + x[i];
                int newY = b + y[i];

                if (newX < 0 || newX > grid.length - 1) {
                    continue;
                }
                if (newY < 0 || newY > grid[0].length - 1) {
                    continue;
                }

                if(visited[newX][newY]){
                    continue;
                }

                if (grid[newX][newY]) {
                    int[] p = {newX, newY};
                    data.offer(p);
                    visited[newX][newY] = true;
                }
            }
        }
        return true;
    }



    public static void main(String[] args) {

        int[][] data = {
                {1,1,0,0,0},
                {0,1,0,0,1},
                {0,0,0,1,1},
                {0,0,0,0,0},
                {0,0,0,0,1}};

        boolean[][] data2 = new boolean[data.length][data[0].length];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] == 1) {
                    data2[i][j] = true;
                }else {
                    data2[i][j] = false;
                }
            }
        }


        System.out.println(new NumberofIslands433().numIslands(data2));


    }

}
