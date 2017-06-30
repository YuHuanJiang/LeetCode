package bestTimeToBuyAndSellStockII;

public class Solution {
	public int maxProfit(int[] prices) {
        int result = 0, length = prices.length;
        
        for(int i = 1; i < length; i++) {
        	if(prices[i] > prices[i - 1]) result += prices[i] - prices[i - 1];
        }
        
        return result;
    }
}
