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

    // O(1) 空间。利用父节点的next关系做层级遍历
    public void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode parent = root;

        TreeLinkNode leftGuard;
        while (parent != null) {
            leftGuard = parent;
            while (parent!= null && parent.left != null) {

                parent.left.next = parent.right;
                parent.right.next = parent.next != null ? parent.next.left : null;
                parent = parent.next;
            }
            parent = leftGuard.left;

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

        new PopulatingNextRightPointersinEachNode().connect2(node);
    }

}
