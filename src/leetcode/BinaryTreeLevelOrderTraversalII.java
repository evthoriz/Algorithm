package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evtHoriz on 15/8/14.
 * Email: evthoriz@gmail.com
 */
public class BinaryTreeLevelOrderTraversalII {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            result.add(0,levelVals);
            accLevelNodes(levelNodes, result);
        }


    }
}
