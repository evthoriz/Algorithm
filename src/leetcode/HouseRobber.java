package leetcode;

/**
 * Created by evtHoriz on 15/8/15.
 * Email: evthoriz@gmail.com
 * 动态规划问题思路
 *
 * 最优子结构
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return maxRob(nums, nums.length - 1);

    }

    public int maxRob(int[] nums, int end) {
        if (end < 0) {
            return 0;
        }
        if (end == 0) {
            return nums[0];
        }

        return Math.max(maxRob(nums, end - 2) + nums[end], maxRob(nums, end - 1));
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[][] d = new int[nums.length][2];
        d[0][0]= 0;
        d[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            d[i][0] = Math.max(d[i-1][0], d[i-1][1]);
            d[i][1] = d[i-1][0] + nums[i];
        }

        return Math.max(d[nums.length - 1][0], d[nums.length - 1][1]);
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob2(new int[]{114, 117, 207, 117, 235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));

    }
}
