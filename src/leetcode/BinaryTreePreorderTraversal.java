package leetcode;

import java.util.*;

/**
 * Created by evtHoriz on 15/8/12.
 * Email: evthoriz@gmail.com
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<Integer>();
        preIter(root, list);
        return list;
    }

    public void preIter(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preIter(root.left, list);
        preIter(root.right, list);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            list.add(node.val);
            TreeNode left = node.left;
            TreeNode right = node.right;
            // 左右节点入栈，右节点先入，因为左节点先pop
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(6);

        System.out.println(new BinaryTreePreorderTraversal().preorderTraversal2(node));
    }

}
