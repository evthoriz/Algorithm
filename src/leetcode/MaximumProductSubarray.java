package leetcode;

/**
 * Created by evtHoriz on 15/8/17.
 * Email: evthoriz@gmail.com
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        int maxSoFar = nums[0], maxToHerePre = nums[0], minToHerePre = nums[0];
        int maxHere, minHere;

        for (int i = 1; i < nums.length; i++) {

            maxHere = Math.max(Math.max(maxToHerePre * nums[i], minToHerePre * nums[i]), nums[i]);
            minHere = Math.min(Math.min(maxToHerePre * nums[i], minToHerePre * nums[i]), nums[i]);

            maxSoFar = Math.max(maxHere, maxSoFar);
            maxToHerePre = maxHere;
            minToHerePre = minHere;
        }
        return maxSoFar;


    }

    public static void main(String[] args) {
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{2,3,-2,4,-1,-9}));
    }
}
