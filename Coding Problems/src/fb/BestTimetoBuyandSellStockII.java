package fb;

public class BestTimetoBuyandSellStockII {
	//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int sum = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]){
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }
    
    public static void main(String[] arg) {
        System.out.println(maxProfit(new int[]{1, 2, 5, 3, 6, 9}));
    }
}
