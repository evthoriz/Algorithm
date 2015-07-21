package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evtHoriz on 15/7/15.
 * Email: evthoriz@gmail.com
 * tips: 树的广度优先遍历，要下一层肯定需要通过上一层来计算，故需要保存每一层的节点。递归参数中传入该层节点。
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null ) {
            return result;
        }
        List<TreeNode> rootNode = new ArrayList<TreeNode>();
        rootNode.add(root);
        List<Integer> rootVal = new ArrayList<Integer>();
        rootVal.add(root.val);
        result.add(rootVal);
        accLevelNodes(rootNode, result);
        return result;

    }

    public void accLevelNodes(List<TreeNode> nodes, List<List<Integer>> result) {

        List<Integer> levelVals = new ArrayList<Integer>();
        List<TreeNode> levelNodes = new ArrayList<TreeNode>();

        for (TreeNode node : nodes) {
            if (node != null) {
                if (node.left!=null) {
                    levelVals.add(node.left.val);
                    levelNodes.add(node.left);
                }
                if (node.right!=null) {
                    levelVals.add(node.right.val);
                    levelNodes.add(node.right);
                }
            }
        }
        if (!levelNodes.isEmpty()) {
            result.add(levelVals);
            accLevelNodes(levelNodes, result);
        }


    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        root.left.left.left = new TreeNode(4);
//        root.right.right.right = new TreeNode(4);


        List<List<Integer>> l = new BinaryTreeLevelOrderTraversal().levelOrder(root);
        return;
    }
}
