package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by evtHoriz on 15/8/12.
 * Email: evthoriz@gmail.com
 */
public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                TreeLinkNode node = queue.poll();
                if (i != queueSize - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode node = new TreeLinkNode(0);
        node.left = new TreeLinkNode(1);
        node.right = new TreeLinkNode(2);
        node.left.left = new TreeLinkNode(3);
        node.left.right = new TreeLinkNode(4);
        node.right.left = new TreeLinkNode(5);
        node.right.right = new TreeLinkNode(6);

        new PopulatingNextRightPointersinEachNode().connect(node);
    }

}
