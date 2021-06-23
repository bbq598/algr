import java.util.*;

public class BinaryTreeLevelOrderTraversal69 {


      public static class TreeNode {
          public int val;
          public TreeNode left, right;
          public TreeNode(int val) {
              this.val = val;
              this.left = this.right = null;
          }
      }



    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        LinkedList<TreeNode> data = new LinkedList<>();

        if (root == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();

        data.add(root);

        while (data.size() != 0) {
            int r = data.size();
            List<Integer> num = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                TreeNode node = data.removeFirst();
                num.add(node.val);
                if (node.left != null) {
                    data.add(node.left);
                }
                if (node.right != null) {
                    data.add(node.right);
                }
            }
            res.add(num);
        }
        return res;
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        // write your code here
        Queue<TreeNode> data1 = new ArrayDeque<>();
        Queue<TreeNode> data2 = new ArrayDeque<>();

        Queue<TreeNode> havaData = null;
        Queue<TreeNode> noData = null;

        if (root == null) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();
        data1.add(root);

        while (!data1.isEmpty() || !data2.isEmpty()) {
            havaData = data1.isEmpty() ? data2 : data1;
            noData = data1.isEmpty() ? data1 : data2;
            List<Integer> re = new ArrayList<>();
            int r = havaData.size();
            for (int i = 0; i < r; i++) {
                TreeNode node = havaData.poll();
                re.add(node.val);
                if (node.left != null) {
                    noData.add(node.left);
                }
                if (node.right != null) {
                    noData.add(node.right);
                }
            }
            res.add(re);
        }
        return res;
    }


    public List<List<Integer>> levelOrder3(TreeNode root) {
        // write your code here
        List<TreeNode> data = new ArrayList<>();
        if (root == null) {
            return null;
        }

        data.add(root);
        data.add(null);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> re = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == null) {
                res.add(re);
                re = new ArrayList<>();
                if (i + 1 != data.size()) {
                    data.add(null);
                    continue;
                }else{
                    break;
                }
            }
            TreeNode node = data.get(i);
            re.add(node.val);
            if (node.left != null) {
                data.add(node.left);
            }
            if (node.right != null) {
                data.add(node.right);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        BinaryTreeLevelOrderTraversal69 t = new BinaryTreeLevelOrderTraversal69();
        List<List<Integer>> res = t.levelOrder3(a);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j));
            }
            System.out.println();

        }
    }

}
