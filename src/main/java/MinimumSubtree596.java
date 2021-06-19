import utilities.TreeNode;

public class MinimumSubtree596 {


    static  class minNode{
        public int min;
        public TreeNode minNode;

        public minNode(int min, TreeNode minNode) {
            this.min = min;
            this.minNode = minNode;
        }

    }

    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        minNode min = new minNode(Integer.MAX_VALUE, root);
        TreeNode minNode = find(min, root);
        return min.minNode;
    }

    private TreeNode find(minNode min, TreeNode node) {
        if (node == null) {
            return new TreeNode(0);
        }
        TreeNode leftNode = find(min, node.left);
        TreeNode rightNode = find(min, node.right);

        int min2 = leftNode.val + rightNode.val + node.val;
        if (min2 < min.min) {
            min.min = min2;
            min.minNode = node;
        }
        return new TreeNode(min2);
    }


    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        //node.left.left = new TreeNode(1);
        //node.left.right = new TreeNode(2);
        //node.right = new TreeNode(2);
        //node.right.left = new TreeNode(-4);
        //node.right.right = new TreeNode(-5);

        MinimumSubtree596 m = new MinimumSubtree596();
        System.out.println(m.findSubtree(node).val);
    }

}
