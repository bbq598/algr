import utilities.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ClosestBinarySearchTreeValueII901 {


    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here


        List<Integer> data = new ArrayList<>();
        sort(root, data);
        return find(data, target, k);
    }

    private List<Integer> find(List<Integer> data, double target, int k) {

        int left = 0;
        int right = data.size() - 1;
        while (left + 1 < right) {

            int mid = left + (right - left) / 2;
            if (data.get(mid) < target) {
                left = mid;
            } else if (data.get(mid) > target){
                right = mid;
            }
        }
        int a = left;
        int b = right;

        for (int i = 0; i < k; i++) {
            if (left < 0) {
                right++;
            } else if (right > data.size() - 1) {
                left--;
            } else if (Math.abs(data.get(left) - target) <= Math.abs(data.get(right) - target)) {
                left--;
            }else{
                right++;
            }
        }

        if (data.size() == 1 && k == 1) {
            return data.subList(0,1);
        }

        return data.subList(left + 1, right);

    }


    private void sort(TreeNode root, List<Integer> data) {
        if (root == null) {
            return;
        }
        sort(root.left, data);
        data.add(root.val);
        sort(root.right, data);
    }




    public static void main(String[] args) {

        TreeNode t = new TreeNode(1);
        //t.left = new TreeNode(1);
        //t.right = new TreeNode(3);
        //t.right.left = new TreeNode(8);
        //t.right.right = new TreeNode(10);
        double target = 0.000;
        int k = 1;
        ClosestBinarySearchTreeValueII901 c = new ClosestBinarySearchTreeValueII901();
        System.out.println(c.closestKValues(t, target, k).toString());

    }
}
