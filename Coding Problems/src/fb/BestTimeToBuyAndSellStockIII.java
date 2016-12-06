package fb;

public class BestTimeToBuyAndSellStockIII {
	//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
	/*
	 * left[i] stores the maxPro can be made using prices[0] ~ prices[i](inclusive) information
	 * right[i] stores the maxPro can be made using prices[i] ~ prices[length - 1] (inclusive) information 
	 */
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int[] left = new int[prices.length + 1];
        int[] right = new int[prices.length + 1];
        int minSoFar = Integer.MAX_VALUE;
        int maxPro = 0;
        for(int i = 0; i < prices.length; i++){
            minSoFar = Math.min(minSoFar, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - minSoFar);
            left[i] = maxPro;
        }
        int maxSoFar = 0;
        maxPro = 0;
        for(int i = prices.length - 1; i >= 0; i--){
            maxSoFar = Math.max(maxSoFar, prices[i]);
            maxPro = Math.max(maxPro, maxSoFar - prices[i]);
            right[i] = maxPro;
        }
        
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }
    
    public int maxProfit2(int[] prices) {
        int h1 = Integer.MIN_VALUE; int h2 = h1;
        int r1 = 0; int r2 = 0;
        for(int price : prices){
            r2 = Math.max(r2, h2 + price);
            h2 = Math.max(h2, r1 - price);
            r1 = Math.max(r1, h1 + price);
            h1 = Math.max(h1, -price);
        }
        return r2;
    }
    
    public static void main(String[] args){
    	int[] nums = {3,2,6,5,0,3};
    	System.out.println(maxProfit(nums));
    }
    
    
}
