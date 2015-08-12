package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by evtHoriz on 15/8/11.
 * Email: evthoriz@gmail.com
 */
public class MaximumDepthofBinaryTree {

    //最简单的思路，bfs,用一个变量记录深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> levelQueue = new LinkedList<TreeNode>();
        levelQueue.offer(root);

        int depth = 0;
        while (!levelQueue.isEmpty()) {
            depth++;
            int qSize = levelQueue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode node = levelQueue.poll();
                if (node.left != null) {
                    levelQueue.offer(node.left);
                }
                if (node.right != null) {
                    levelQueue.offer(node.right);
                }

            }
        }
        return depth;
    }

    //递推，最大深度是左右子树的最大深度＋1
    public int maxDepth2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth2(node.left), maxDepth2(node.right));
    }

    
    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
//        node.left.left = new TreeNode(3);
//        node.left.right = new TreeNode(4);
//        node.right.left = new TreeNode(5);
//        node.right.right = new TreeNode(6);

        System.out.println(new MaximumDepthofBinaryTree().maxDepth(node));
    }
}
