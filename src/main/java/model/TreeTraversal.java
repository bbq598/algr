package model;

import utilities.TreeNode;

public class TreeTraversal {

    //中序
    public void treaversal(TreeNode root) {
        if (root == null) {
            return;
        }

        treaversal(root.left);
        System.out.println(root.val);
        treaversal(root.right);
    }

    //前序
    public void treaversal2(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        treaversal2(root.left);
        treaversal2(root.right);
    }


    //后序
    public void treaversal3(TreeNode root) {
        if (root == null) {
            return;
        }
        treaversal3(root.left);
        treaversal3(root.right);
        System.out.println(root.val);
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        TreeTraversal t = new TreeTraversal();
        t.treaversal3(root);

    }


}
