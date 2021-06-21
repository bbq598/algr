import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TravelingSalesmanProblem816 {



    public int minCost(int n, int[][] roads) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        res.add(Integer.MAX_VALUE);
        int cost = 0;
        int[][] graph = contructGraph(roads, n);
        Set<Integer> visited = new HashSet<>();
        visited.add(1);

        List<Integer> path = new ArrayList<>();
        path.add(1);
        find(1, n,cost, path, visited,res, graph);
        return res.get(0);
    }

    private void find(int city, int n, int cost,List<Integer> path, Set<Integer> visited, List<Integer> res, int[][] graph) {
        if (visited.size() == n) {
            int c = Math.min(cost, res.get(0));
            res.set(0, c);
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (visited.contains(i)) {
                continue;
            }

            if (hasBetterPath(graph, path, i)) {
                continue;
            }
            path.add(i);
            visited.add(i);
            find(i, n, cost + graph[city][i],path, visited, res, graph);
            visited.remove(i);
            path.remove(path.size() - 1);
        }
    }

    private boolean hasBetterPath(int[][] graph, List<Integer> path, int city) {

        for (int i = 1; i < path.size(); i++) {
            int a = path.get(i - 1);
            int b = path.get(i);
            int last = path.get(path.size() - 1);

            if (graph[a][b] + graph[last][city] > graph[a][last] + graph[b][city]) {
                return true;
            }
        }
        return false;

    }


    //private boolean hasBetterPath(int[][] graph, List<Integer> path, int city) {
    //
    //    for (int i = 0; i < path.size(); i++) {
    //        int a = path.get(i);
    //        int b = path.get(i - 1);
    //        int last = path.get(path.size() - 1);
    //        if (graph[a][b] > 100 ||  graph[last][city] > 100 || graph[a][city] > 100 || graph[b][last] > 100 ){
    //            continue;
    //        }
    //        if (graph[a][b] + graph[last][city] > graph[a][city] + graph[b][last]) {
    //            return true;
    //        }
    //        if (graph[a][last] > graph[a][city]) {
    //            return true;
    //        }
    //    }
    //    return false;
    //
    //}

    private int[][] contructGraph(int[][] nums,int n) {

        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                graph[i][j] = Integer.MAX_VALUE / 16;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i][0];
            int b = nums[i][1];
            int c = nums[i][2];
            c = Math.min(Math.min(graph[a][b],graph[b][a]), c);
            graph[a][b] = c;
            graph[b][a] = c;
        }
        return graph;
    }


    public static void main(String[] args) {

        int[][] nums = {{1, 2, 1}, {1, 3, 4},{1, 4, 2}, {2, 3, 5}, {3, 4, 2},{2, 4, 8}};
        int n = 4;
        TravelingSalesmanProblem816 t = new TravelingSalesmanProblem816();

        System.out.println(t.minCost(n, nums));

    }

}
