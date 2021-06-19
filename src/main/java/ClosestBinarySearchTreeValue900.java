import utilities.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ClosestBinarySearchTreeValue900 {



    //public int closestValue(TreeNode root, double target) {
    //    // write your code here
    //    List<Integer> data = new ArrayList<>();
    //    sort(root, data);
    //    return find(data, target);
    //}
    //
    //private int find(List<Integer> data, double target) {
    //
    //    int left = 0;
    //    int right = data.size() - 1;
    //    while (left + 1 < right) {
    //
    //        int mid = left + (right - left) / 2;
    //        if (data.get(mid) < target) {
    //            left = mid;
    //        } else if (data.get(mid) > target){
    //            right = mid;
    //
    //        }
    //    }
    //
    //    return Math.abs(target - data.get(left)) < Math.abs(target - data.get(right)) ? data.get(left) : data.get(right);
    //
    //}
    //
    //
    //private void sort(TreeNode root, List<Integer> data) {
    //    if (root == null) {
    //        return;
    //    }
    //    sort(root.left, data);
    //    data.add(root.val);
    //    sort(root.right, data);
    //}

    public int closestValue(TreeNode root, double target) {
        // write your code here

        TreeNode high = root;
        TreeNode low = root;

        while (root != null) {
            if (root.val < target) {
                low = root;
                root = root.right;
            }else{
                high = root;
                root = root.left;
            }
        }

        return Math.abs(high.val - target) < Math.abs(low.val - target) ? high.val : low.val;

    }




    public static void main(String[] args) {

        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(4);
        t.left.left = new TreeNode(2);
        t.right = new TreeNode(9);
        t.right.left = new TreeNode(8);
        t.right.right = new TreeNode(10);
        ClosestBinarySearchTreeValue900 c = new ClosestBinarySearchTreeValue900();
        double target = 6.12;
        System.out.println(c.closestValue(t, target));

    }


}
