package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Created by evtHoriz on 15/8/12.
 * Email: evthoriz@gmail.com
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inIter(root, list);
        return list;
    }

    public void inIter(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inIter(node.left, list);
        list.add(node.val);
        inIter(node.right, list);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        HashSet<TreeNode> set = new HashSet<TreeNode>();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                list.add(node.val);
                continue;
            }
            if (set.contains(node)) {
                list.add(node.val);
                continue;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            stack.push(node);
            set.add(node);
            if (node.left != null) {
                stack.push(node.left);
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
//        TreeNode node = new TreeNode(3);
//        node.left = new TreeNode(1);
//        node.left.right = new TreeNode(2);

        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal2(node));
    }
}
