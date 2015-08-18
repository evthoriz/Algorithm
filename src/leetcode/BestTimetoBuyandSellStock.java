package leetcode;

/**
 * Created by evtHoriz on 15/8/17.
 * Email: evthoriz@gmail.com
 * 2,4,5,2,1,8,3,6,5,9,8,1
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int min = prices[0];

        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                max = Math.max(prices[i] - min, max);
            } else {
                min = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimetoBuyandSellStock().maxProfit(new int[]{2, 4, 5, 2, 1, 8, 3, 6, 5, 9, 8, 19}));
    }
}
