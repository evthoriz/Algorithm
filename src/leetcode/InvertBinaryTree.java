package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evtHoriz on 15/7/16.
 * Email: evthoriz@gmail.com
 * <p/>
 * 倒置二叉树，即交换每个节点的左右子树。从root节点开始，交换它的左右节点。
 * 广度优先：一层一层进行。一层交换完成后，构造下一层的节点，递归调用自己。
 * 深度优先：交换左子树再交换右子树。
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> rootNode = new ArrayList<TreeNode>();
        rootNode.add(root);
        invert(rootNode);
        return root;
    }

    public void invert(List<TreeNode> nodeList) {
        List<TreeNode> nextLevel = new ArrayList<TreeNode>();
        if (nextLevel.size() == 0) return;
        for (TreeNode node : nodeList) {
            if (node.left == null && node.right == null) continue;
            if (node.left != null) nextLevel.add(node.left);
            if (node.right != null) nextLevel.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

        }
        invert(nextLevel);
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        invert2(root);
        return root;
    }

    public void invert2(TreeNode node) {
        if (node.left == null && node.right == null) {
            return;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        if (node.left!=null) {
            invert2(node.left);
        }

        if (node.right!=null) {
            invert2(node.right);
        }
    }




    public static void main(String[] args) {
    }

}
