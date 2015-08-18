package leetcode;

/**
 * Created by evtHoriz on 15/8/18.
 * Email: evthoriz@gmail.com
 * 以i为root 左树有0到i-1，右树有i+1到n
 * <p/>
 * 设所求不同的树数目为 f(i)
 * f(i) = f(i-1)*f(0) + f(i-2)*f(1) + ... + f(0)* f(i-1)
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {

        int[] f = new int[n + 1];

        f[0] = 1;
        f[1] = 1;
        f[2] = 2;

        for (int i = 3; i <= n; i++) {
            f[i] = 0;
            for (int j = i - 1; j >= 0; j--) {
                f[i] += f[i - 1 - j] * f[j];
            }
        }

        return f[n];

    }
}
