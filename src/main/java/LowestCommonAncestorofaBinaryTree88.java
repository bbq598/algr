import utilities.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorofaBinaryTree88 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here

        if (root == null) {
            return root;
        }

        List<TreeNode> path = new ArrayList<>();
        List<TreeNode> list1 = new ArrayList<>();
        path.add(root);
        find(root, B, path, list1);
        List<TreeNode> list2 = new ArrayList<>();
        path.clear();
        path.add(root);
        find(root,A,path,list2);
        int r = Math.min(list1.size(), list2.size());

        for (int i = 0; i < r; i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return list1.get(i - 1);
            }
        }

        return list1.get(r -1 );
    }

    private void find(TreeNode node, TreeNode target, List<TreeNode> path, List<TreeNode> res) {
        if (node == null) {
            return;
        }
        if (node == target) {
            for (int i = 0; i < path.size(); i++) {
                res.add(path.get(i));
            }
        }
        if (node.left != null) {
            path.add(node.left);
            find(node.left, target, path, res);
            path.remove(node.left);
        }
        if (node.right != null) {
            path.add(node.right);
            find(node.right, target, path, res);
            path.remove(node.right);
        }

    }



    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        //node.left = new TreeNode(3);
        node.right = new TreeNode(2);
        //node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(3);
        node.right.right.right = new TreeNode(4);
        node.right.right.right.right = new TreeNode(5);
        LowestCommonAncestorofaBinaryTree88 l = new LowestCommonAncestorofaBinaryTree88();


        l.lowestCommonAncestor(node, node.right.right, node.right.right.right.right);
    }

}
