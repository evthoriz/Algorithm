package leetcode;

import java.util.Arrays;

/**
 * Created by evtHoriz on 15/4/21.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num.length < 3) {
            return 0;
        }
        Arrays.sort(num);
        long closet = Integer.MAX_VALUE;
        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int lastsum = 0;
            for (int lo = i + 1, hi = num.length - 1; lo < hi; ) {
                int sum = num[i] + num[lo] + num[hi];
                System.out.println("sum:" + sum);
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    lo++;
                    while (lo < hi && num[lo] == num[lo - 1]) lo++;
                } else {
                    hi--;
                    while (lo < hi && num[hi] == num[hi + 1]) hi--;
                }
                if (Math.abs(sum - target) < Math.abs(closet - target)) {
                    closet = sum;
                }
                if (lastsum * sum < 0) {
                    System.out.println("lastsum:" + lastsum + ", sum:" + sum);
                    break;
                }
                lastsum = sum;
            }
        }
        return (int)closet;
    }

    public static void main(String[] args) {

        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1));
    }
}
