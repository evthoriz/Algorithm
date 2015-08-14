package leetcode;

/**
 * Created by evtHoriz on 15/7/19.
 * Email: evthoriz@gmail.com
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        boolean ls, rs;
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        } else {
            ls = hasPathSum(root.left, sum - root.val);
            rs = hasPathSum(root.right, sum - root.val);
        }

        return ls || rs;
    }

}
