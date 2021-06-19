import utilities.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreetoLinkedList453 {

    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        List<TreeNode> node = new ArrayList<>();
        find(node, root);
        for (int i = 0; i < node.size() - 1; i++) {
            node.get(i).right = node.get(i + 1);
            node.get(i).left = null;
        }
        node.get(node.size() - 1).left = null;

    }

    private void find(List<TreeNode> node, TreeNode root) {
        if (root == null) {
            return;
        }
        node.add(root);
        find(node, root.left);
        find(node, root.right);
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        //node.right = new TreeNode(5);
        //node.left.left = new TreeNode(3);
        //node.left.right = new TreeNode(4);
        //node.right.right = new TreeNode(6);
        FlattenBinaryTreetoLinkedList453 f = new FlattenBinaryTreetoLinkedList453();
        f.flatten(node);

    }
}
