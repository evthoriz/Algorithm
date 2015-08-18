package leetcode;

/**
 * Created by evtHoriz on 15/8/16.
 * Email: evthoriz@gmail.com
 * <p/>
 * [−2,1,−3,4,−1,2,1,−5,4]
 * <p/>
 * [4,−1,2,1] has the largest sum = 6
 */
public class MaximumSubarray {


    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] d = new int[nums.length];

        d[0] = nums[0];
        int max = d[0];

        for (int i = 1; i < nums.length; i++) {
            if (d[i - 1] > 0) {
                d[i] = d[i - 1] + nums[i];
            } else {
                d[i] = nums[i];
            }
            max = Math.max(max, d[i]);
        }

        return max;

    }

    public int maxSubArray2(int[] nums) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public int maxSubArray3(int[] nums) {
        int maxSoFar = nums[0], maxToHerePre = nums[0];
        int maxToHere;

        for (int i = 1; i < nums.length; i++) {
            //  算上nums[i] 最大值是 在前一个算上nums[i-1]的最大值上累加与nums[i]中的较大者
            maxToHere = Math.max(maxToHerePre + nums[i], nums[i]);
            // 更新最大值
            maxSoFar = Math.max(maxSoFar, maxToHere);
            // 更新前一个最大值
            maxToHerePre = maxToHere;
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray3(new int[]{-2, -1, 2, 3, -2, 4, -1, -9, 6}));
    }

}
