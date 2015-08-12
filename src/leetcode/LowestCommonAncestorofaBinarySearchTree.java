package leetcode;

import apple.laf.JRSUIUtils;

/**
 * Created by evtHoriz on 15/8/12.
 * Email: evthoriz@gmail.com
 *          6
 *        /    \
 *       2     8
 *      / \   / \
 *     0  4  7  9
 *       / \
 *      3  7
 * 因为是[二叉搜索树]，所以左子数小于节点，右子树大于节点
 */
public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }


}
