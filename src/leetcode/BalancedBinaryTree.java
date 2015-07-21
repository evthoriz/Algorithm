package leetcode;

/**
 * Created by evtHoriz on 15/7/14.
 * Email: evthoriz@gmail.com
 *
 * tips: 平衡二叉树的定义是对于所有节点，它的左右子树的高度差不超过1。空树也属于平衡二叉树
 * 和叶子节点到根的距离不超过q1并不等价。
 *         ____1____
          /         \
         2           2
        /  \        / \
       3    3      3   3
      /\    /\    /\
     4  4  4  4  4  4
    /\
   5  5
 *
 * */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return calcHeight(root) != -1;
    }

    public int calcHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lh = calcHeight(node.left);
        if (lh==-1) return -1;
        int rh = calcHeight(node.right);
        if (rh == -1) return -1;

        System.out.println("lh:" + lh + ", rh:" + rh);
        if (lh - rh > 1 || lh - rh < -1) {
            System.out.println("more than 1");
            return -1;
        }
        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);




        System.out.println(new BalancedBinaryTree().isBalanced(root));
    }

}
