import utilities.DirectedGraphNode;

import java.util.*;

public class TopologicalSorting127 {



    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here

        Map<Integer, List<DirectedGraphNode>> index = new HashMap<>();
        Map<DirectedGraphNode, Integer> data = new HashMap<>();

        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).neighbors != null || graph.get(i).neighbors.size() != 0) {
                List<DirectedGraphNode> neighbors = graph.get(i).neighbors;
                for (int j = 0; j < neighbors.size(); j++) {
                    data.put(neighbors.get(j), data.getOrDefault(neighbors.get(j), 0) + 1);
                }
            }
        }

        index.put(0, graph);

        for (DirectedGraphNode node : data.keySet()) {
            int n = data.get(node);
            if (!index.containsKey(n)) {
                List<DirectedGraphNode> list = new ArrayList<>();
                index.put(n, list);
            }
            List<DirectedGraphNode> list2 = index.get(n);
            list2.add(node);
            index.get(0).remove(node);
        }

        Queue<DirectedGraphNode> queue = new ArrayDeque<>();

        for (int i = 0; i < index.get(0).size(); i++) {
            DirectedGraphNode d = index.get(0).get(i);
            queue.offer(d);
            index.get(0).remove(d);
        }


        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            DirectedGraphNode node2 = queue.poll();
            res.add(node2);
            if (node2.neighbors != null || node2.neighbors.size() != 0) {
                List<DirectedGraphNode> list = node2.neighbors;
                for (int i = 0; i < list.size(); i++) {
                    DirectedGraphNode node = list.get(i);
                    int n = data.getOrDefault(node, 0);
                    data.put(node, n - 1);
                    index.get(n).remove(node);
                    if (!index.containsKey(n - 1)) {
                        index.put(n - 1, new ArrayList<DirectedGraphNode>());
                    }
                    index.get(n - 1).add(node);
                }
                if (index.get(0).size() != 0) {
                    for (int i = 0; i < index.get(0).size(); i++) {
                        DirectedGraphNode d = index.get(0).get(i);
                        queue.offer(d);
                        index.get(0).remove(d);
                    }
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {

        DirectedGraphNode d = new DirectedGraphNode(0);
        DirectedGraphNode d1 = new DirectedGraphNode(1);
        DirectedGraphNode d2 = new DirectedGraphNode(2);
        DirectedGraphNode d3 = new DirectedGraphNode(3);
        DirectedGraphNode d4 = new DirectedGraphNode(4);
        DirectedGraphNode d5 = new DirectedGraphNode(5);

        List<DirectedGraphNode> l = new ArrayList<>();
        l.add(d1);
        l.add(d2);
        l.add(d3);
        d.neighbors = l;

        List<DirectedGraphNode> l1 = new ArrayList<>();
        l1.add(d4);
        d1.neighbors = l1;

        List<DirectedGraphNode> l2 = new ArrayList<>();
        l2.add(d4);
        l2.add(d5);
        d2.neighbors = l2;

        List<DirectedGraphNode> l3 = new ArrayList<>();
        l3.add(d4);
        l3.add(d5);
        d3.neighbors = l3;
        TopologicalSorting127 t = new TopologicalSorting127();

        ArrayList<DirectedGraphNode> data = new ArrayList<>();
        data.add(d);
        data.add(d1);
        data.add(d2);
        data.add(d3);
        data.add(d4);
        data.add(d5);
        t.topSort(data);

    }

}
