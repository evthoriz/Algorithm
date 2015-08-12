package test;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evtHoriz on 15/8/11.
 * Email: evthoriz@gmail.com
 *
 *     0
 *    / \
 *   1   2
 *  /\   /\
 * 3 4  5 6
 *
 */
public class WalkTree {

    //---------------- DFS---------------//

    public void preIter(TreeNode node, List<TreeNode> l) {
        if (node == null) {
            return;
        }
        l.add(node);
        preIter(node.left, l);
        preIter(node.right, l);
    }

    public void midIter(TreeNode node, List<TreeNode> l) {
        if (node == null) {
            return;
        }
        midIter(node.left, l);
        l.add(node);
        midIter(node.right, l);
    }

    public void postIter(TreeNode node, List<TreeNode> l) {
        if (node == null) {
            return;
        }

        postIter(node.left, l);
        postIter(node.right, l);
        l.add(node);
    }
    
    //---------------- BFS ----------------//

    public void bfsIter(List<TreeNode> nodeList, int offset) {
        if (nodeList.size() == offset) {
            return;
        }

        List<TreeNode> tmp =  new ArrayList<TreeNode>(nodeList.subList(offset, nodeList.size()));

        for (TreeNode node : tmp) {
            if (node.left != null) {
                nodeList.add(node.left);
            }
            if (node.right != null) {
                nodeList.add(node.right);
            }
            offset++;
        }

        bfsIter(nodeList, offset);
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(6);


        List<TreeNode> l = new ArrayList<TreeNode>();
        l.add(node);
        new WalkTree().bfsIter(l, 0);
        System.out.println(l);

    }
    
}
