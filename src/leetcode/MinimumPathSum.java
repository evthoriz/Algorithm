package leetcode;

/**
 * Created by evtHoriz on 15/8/18.
 * Email: evthoriz@gmail.com
 *
 *  有两种空间优化方式
 * 1. 按行遍历时只要保存前一个值即可，所以存储用的sum[][]可以降到一维数组。
 * 2. 直接在in-place 但是会改变原来的数组。
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];


        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            sum[0][j] = sum[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {


                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }

        return sum[m - 1][n - 1];

    }

    public static void main(String[] args) {
        System.out.println(new MinimumPathSum().minPathSum(new int[][]{{1, 2}, {1, 1}}));
    }

}
