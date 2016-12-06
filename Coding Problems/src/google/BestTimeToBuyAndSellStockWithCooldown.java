package google;

public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int buy = 0, preBuy = 0, sell = 0, preSell = -prices[0], rest = 0, preRest = 0;
        for(int i = 1; i < len; i++){
        	buy = Math.max(preBuy, preRest - prices[i]);
        	sell = Math.max(preSell, preBuy + prices[i]);
        	rest = Math.max(preRest, Math.max(preBuy, preSell));
        	preBuy = buy;
        	preSell = sell;
        	preRest = rest;
        }
        return sell;
    }
    
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];
        int[] rest = new int[len];
        buy[0] = -prices[0];
        for(int i = 1; i < len; i++){
            buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            rest[i] = Math.max(rest[i - 1], Math.max(sell[i - 1], buy[i - 1]));
        }
        return sell[len - 1];
    }
}
