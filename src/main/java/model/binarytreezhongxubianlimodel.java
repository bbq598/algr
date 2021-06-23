package model;

import utilities.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


public class binarytreezhongxubianlimodel {


    static class Bst{
        public Stack<TreeNode> data;
        public Bst(TreeNode root) {
            data = new Stack<>();
            while (root != null) {
                data.add(root);
                root = root.left;
            }
        }
        public boolean hasNext() {
            return !data.isEmpty();
        }
        public TreeNode next() {
            TreeNode curr = data.pop();
            TreeNode node = curr;
            if (node.right != null) {
                node = node.right;
                data.add(node);
                while (node.left != null) {
                    data.add(node.left);
                    node = node.left;
                }
            }
            return curr;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(11);
        root.right.right = new TreeNode(12);
        Bst b = new Bst(root);
        while (b.hasNext()) {
            System.out.println(b.next().val);
        }

    }


}
