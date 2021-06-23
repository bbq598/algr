import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths480 {


    public static class TreeNode {
        public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }

    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> r = new ArrayList<>();
        if (root == null ) {
            return r;
        }
        List<TreeNode> result = new ArrayList<>();
        result.add(root);
        findPath(root, result, r);


        return r;
    }


    private void findPath(TreeNode node, List<TreeNode> res, List<String> r) {

        if (node.left == null && node.right == null) {
            add(res, r);
            return;
        }
        if (node.left != null) {
            res.add(node.left);
            findPath(node.left, res, r);
            res.remove(res.size() - 1);
        }

        if (node.right != null) {
            res.add(node.right);
            findPath(node.right,res, r);
            res.remove(res.size() - 1);
        }
    }

    private void add(List<TreeNode> result, List<String> res) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                str.append(result.get(i).val);
                if (i + 1 < result.size()) {
                    str.append("->");
                }
            }
        res.add(str.toString());
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(5);

        System.out.println(new BinaryTreePaths480().binaryTreePaths(node).toString());
    }




}
