package leetcode;

/**
 * Created by evtHoriz on 15/8/11.
 * Email: evthoriz@gmail.com
 *
 * 2,4,5,2,1,8,3,6,5,9,8,1
 */
public class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0;
        int pre = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > pre) {
                profit += prices[i] - pre;
            }
            pre = prices[i];
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,4,5,2,1,8,3,6,5,9,8,1};
        System.out.println(new BestTimetoBuyandSellStockII().maxProfit(a));
    }
}
