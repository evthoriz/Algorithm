package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evtHoriz on 15/8/12.
 * Email: evthoriz@gmail.com
 * 6
 * /    \
 * 2     8
 * / \   / \
 * 0  4  7  9
 * / \
 * 3  7
 * <p/>
 * 误区，用val来比较的话会出现找到好几个LCA，这是不对的，两个节点的LCA只有一个。所以要用
 */
public class LowestCommonAncestorofaBinaryTree {
    // 如果不是二叉搜索书，只是二叉树
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
//        if (root.val == p.val || root.val == q.val)
        if (root == p || root == q) {
            return root;
        }

        TreeNode l = LCA(root.left, p, q);
        TreeNode r = LCA(root.right, p, q);

        if (l != null && r != null) {
            return root;
        }

        return l != null ? l : r;
    }

    public boolean findNode(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        if (node.val == p.val || node.val == q.val) {
            return true;
        }
        boolean l = findNode(node.left, p, q);
        boolean r = findNode(node.right, p, q);
        // 如果左右子树都找到了，说明该节点就是了。
        if (l && r) {
            return true;
        }
        // 如果左右子数中有一个找到了，那么返回找到。
        return l ? l : r;
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(6);
        node.left = new TreeNode(2);
        node.right = new TreeNode(8);

        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(9);

        node.left.right.left = new TreeNode(3);
        node.left.right.right = new TreeNode(7);

        System.out.println(new LowestCommonAncestorofaBinaryTree().LCA(node, new TreeNode(0), new TreeNode(3)));

    }
}
