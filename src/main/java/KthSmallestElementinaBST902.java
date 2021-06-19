import utilities.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinaBST902 {


    public int kthSmallest(TreeNode root, int k) {
        // write your code here

        List<Integer> res = new ArrayList<>();
        sort(res, root);
        return res.get(k - 1);
    }

    private void sort(List<Integer> res, TreeNode node) {
        if (node == null) {
            return;
        }
        sort(res, node.left);
        res.add(node.val);
        sort(res, node.right);
    }




    public static void main(String[] args) {

    }

}
