import java.util.*;

public class KnightShortestPath611 {


      static class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here

        int[] moveX = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] moveY = {2, -2, 2, -2, 1, -1, 1, -1};
        if (grid == null || grid.length == 0) {
            return -1;
        }


        if (source.y == destination.y && source.x == destination.x) {
            return 0;
        }

        //Set<Integer> visited = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> data = new ArrayDeque<>();

        //int key = source.x * grid[0].lengthgth + source.y;
        //visited.add(key);
        visited[source.x][source.y] = true;
        int[] s = {source.x, source.y};
        data.offer(s);
        int length = 0;

        while (!data.isEmpty()) {
            int r = data.size();
            length++;
            for (int j = 0; j < r; j++) {
                int[] point = data.poll();
                for (int i = 0; i < moveX.length; i++) {
                    int newX = point[0] + moveX[i];
                    int newY = point[1] + moveY[i];
                    if (newX < 0 || newX > grid.length - 1) {
                        continue;
                    }

                    if (newY < 0 || newY > grid[0].length - 1) {
                        continue;
                    }
                    if (visited[newX][newY]) {
                        continue;
                    }

                    if(grid[newX][newY]) {
                        continue;
                    }

                    if (newX == destination.x && newY == destination.y) {
                        return length;
                    }

                        int[] p = {newX, newY};
                        data.offer(p);
                        visited[newX][newY] = true;

                }
            }
        }

        return -1;

    }




    public static void main(String[] args) {

        int[][] data = {
                {1,1,0,0},
                {0,0,0,0},
                {0,1,1,1},
                {1,1,1,0}
        };

        boolean[][] data2 = new boolean[data.length][data[0].length];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] == 1) {
                    data2[i][j] = true;
                } else {
                    data2[i][j] = false;
                }
            }
        }
        int[] source = {1, 0};
        Point s = new Point(1, 0);
        int[] des = {2, 2};
        Point d = new Point(2, 2);

        System.out.println(new KnightShortestPath611().shortestPath(data2, s, d));

    }


}
