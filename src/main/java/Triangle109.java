import java.util.HashMap;
import java.util.Map;

public class Triangle109 {


    public int minimumTotal(int[][] triangle) {
        // write your code here


        int[][] data = new int[triangle.length][triangle.length];

        return find(triangle, 0, 0, data);

    }


    private int find(int[][] triangle, int x, int y, int[][] data) {
        if (x == triangle.length) {
            return 0;
        }

        if (data[x][y] != 0) {
            return data[x][y];
        }

        int left = find(triangle, x + 1, y,data);
        int right = find(triangle, x + 1, y + 1,data);

        int min = Math.min(left, right);
        int length = min + triangle[x][y];
        data[x][y] = length;
        return length;
    }

    public static void main(String[] args) {
        int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        Triangle109 t = new Triangle109();
        System.out.println(t.minimumTotal(triangle));

    }
}
