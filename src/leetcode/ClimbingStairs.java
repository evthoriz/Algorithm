package leetcode;

/**
 * Created by evtHoriz on 15/8/16.
 * Email: evthoriz@gmail.com
 *
 * 1 2 3 5 8
 *
 */
public class ClimbingStairs {

    public int climbStairs(int n) {

        if (n == 0) {
            return 0;
        }

        int a = 1;
        int b = 2;
        int sum = 0;

        for (int i = 3; i <= n; i++) {
            sum = a+b;
            a = b;
            b = sum;
        }
        return sum;
    }

}
