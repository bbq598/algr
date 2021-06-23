public class BalancedBinaryTree93 {

  public static class TreeNode {
     public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }

  static class Result{
      public boolean isBalance;
      public int height;

      public Result(Boolean isBalance, int height) {
          this.isBalance = isBalance;
          this.height = height;
      }
  }



    public boolean isBalanced(TreeNode root) {
        // write your code here

        return  isBalanced2(root).isBalance;
    }

    private Result isBalanced2(TreeNode root) {

        if (root == null) {
            return new Result(true, 0);
        }

        Result left = isBalanced2(root.left);
        Result right = isBalanced2(root.right);

        boolean isBalance = true;

        if (left.isBalance == false || right.isBalance == false) {
            isBalance = false;
        }

        if (Math.abs(left.height - right.height) > 1) {
            isBalance = false;
        }

        return new Result(isBalance, Math.max(left.height, right.height) + 1);
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        BalancedBinaryTree93 b = new BalancedBinaryTree93();

        System.out.println(b.isBalanced(root));


    }

}
