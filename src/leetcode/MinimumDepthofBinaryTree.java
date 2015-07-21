package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evtHoriz on 15/7/15.
 * Email: evthoriz@gmail.com
 *
 * tips: 求最小深度，用深度遍历需要走完整颗树，用广度优先则只要遇到第一个叶子即可。
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<TreeNode> rootNode = new ArrayList<TreeNode>();
        rootNode.add(root);
        return calcDepthByLevel(rootNode);
    }

    public int calcDepthByLevel(List<TreeNode> nodelist) {
        List<TreeNode> levellist = new ArrayList<TreeNode>();
        for (TreeNode node : nodelist) {
            TreeNode ln = node.left;
            TreeNode rn = node.right;

            if (ln == null && rn == null) {
                return 1;
            }
            if (ln != null) {
                levellist.add(ln);
            }
            if (rn != null) {
                levellist.add(rn);
            }
        }
        return calcDepthByLevel(levellist) + 1;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);


        System.out.println(new MinimumDepthofBinaryTree().minDepth(root));
    }
}
