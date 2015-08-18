package leetcode;

/**
 * Created by evtHoriz on 15/8/17.
 * Email: evthoriz@gmail.com
 *
 * 除了第一行和第一列，其余的每个格子都可以从上和左两个格子过来，故 d[i][j] = d[i-1][j] + d[i][j-1]
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {

        int d[][] = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = (i-1>=0?d[i-1][j]:0) + (j-1>=0?d[i][j-1]:0);
                d[0][0] = 1;
            }
        }

        return d[m-1][n-1];

    }


    /**
     * m-1 步向下
     * n-1 步向右
     * 一共 m+n-2步
     *
     * 从 m+n-2 步 中选择 m-1步向下，剩下的就是n-1步向右了
     * C(m+n-2, m-1)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(30,30));
    }
}
