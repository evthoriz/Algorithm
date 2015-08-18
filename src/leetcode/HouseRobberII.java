package leetcode;

/**
 * Created by evtHoriz on 15/8/16.
 * Email: evthoriz@gmail.com
 * <p/>
 * 打破环只要假设某一个不被抢即可。
 * 假设第0个不被抢 那么环就被从0这个位置打断了，变成了从 1 到 n 的一段。
 * 假设第n个不被抢，那么环断开变成 从 0 到 n-1 这样一段
 * <p/>
 * 由于第0个和第n个是相邻的，因此这两种情形就满足了所有情形的，毕竟不可能三个连续的都没被抢。
 */
public class HouseRobberII {

    public int Rob_(int[] nums, int lo, int hi) {

        int[][] d = new int[hi + 1][2];
        d[lo][0] = 0;
        d[lo][1] = nums[lo];


        for (int i = lo + 1; i <= hi; i++) {
            d[i][0] = Math.max(d[i - 1][0], d[i - 1][1]);
            d[i][1] = d[i - 1][0] + nums[i];
        }

        return Math.max(d[hi][0], d[hi][1]);
    }

    public int Rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(Rob_(nums, 0, nums.length - 2), Rob_(nums, 1, nums.length - 1));
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobberII().Rob(new int[]{1, 3, 1}));
    }
}
