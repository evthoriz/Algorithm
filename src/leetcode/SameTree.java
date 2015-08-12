package leetcode;

/**
 * Created by evtHoriz on 15/8/11.
 * Email: evthoriz@gmail.com
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if ((p == null && q != null) || (q == null && p != null)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        if (!isSameTree(p.left, q.left)) {
            return false;
        }

        if (!isSameTree(p.right, q.right)) {
            return false;
        }

        return true;

    }

    public static void main(String[] args) {

    }
}
