package bestTimeToBuyAndSellStock;

public class Solution {
	public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, result = 0;
        int length = prices.length, tmp;
        
        for(int i = 0; i < length; i++) {
        	tmp = prices[i];
        	if(tmp < min) min = tmp;
        	tmp -= min;
            if(tmp > result) result = tmp;
        }
        
        return result;
    }
}
