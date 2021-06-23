import java.util.*;

public class CloneGraph137 {


      static class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) {
          label = x;
          neighbors = new ArrayList<UndirectedGraphNode>();
      }
  }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here

        if (node == null) {
            return node;
        }

        List<UndirectedGraphNode[]> data = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        Map<Integer, UndirectedGraphNode> old = new HashMap<>();
        queue.offer(node);
        old.put(node.label, node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            if (n.neighbors != null && n.neighbors.size() != 0) {
                for (UndirectedGraphNode n1 : n.neighbors) {
                    if (!old.containsKey(n1.label)) {
                        queue.offer(n1);
                        old.put(n1.label, n1);
                    }
                }
            }
        }
        Map<Integer, UndirectedGraphNode> newNode = new HashMap<>();

        for (Integer n : old.keySet()) {
            UndirectedGraphNode newN = new UndirectedGraphNode(n);
            newNode.put(newN.label, newN);
        }

        for (Integer n : old.keySet()) {
            if (old.get(n).neighbors != null || old.get(n).neighbors.size() != 0) {
                List<UndirectedGraphNode> list = old.get(n).neighbors;
                List<UndirectedGraphNode> newList = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    int label = list.get(i).label;
                    UndirectedGraphNode n2 = newNode.get(label);
                    newList.add(n2);
                }
                newNode.get(n).neighbors = newList;
            }
        }

        return newNode.get(node.label);

    }


    public static void main(String[] args) {

        UndirectedGraphNode node = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(4);
        List<UndirectedGraphNode> list1 = new ArrayList<>();
        list1.add(node);
        list1.add(node3);
        node2.neighbors = list1;
        List<UndirectedGraphNode> list2 = new ArrayList<>();
        list2.add(node2);
        list2.add(node3);
        node.neighbors = list2;

        List<UndirectedGraphNode> list3 = new ArrayList<>();
        list3.add(node);
        list3.add(node2);
        node3.neighbors = list2;

        CloneGraph137 c = new CloneGraph137();
        System.out.println(c.cloneGraph(node).label);
    }

}
