package fb;

public class BestTimeToBuyAndSellStock {
	//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	/*
	 * recording the min price so far and calculte the profit
	 */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int curMax = 0;
        int minSoFar = Integer.MAX_VALUE;
        int max = 0;
        for(int price : prices){
            minSoFar = Math.min(price, minSoFar);
            max = Math.max(max, price - minSoFar);
        }
        return max;
    }
}
