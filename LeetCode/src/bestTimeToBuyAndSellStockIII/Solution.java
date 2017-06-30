package bestTimeToBuyAndSellStockIII;

public class Solution {
	public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        int tmp;
        
        for(int i = 0; i < prices.length; i++) {
        	tmp = prices[i];
        	release2 = Math.max(release2, hold2 + tmp);
        	hold2 = Math.max(hold2, release1 - tmp);
        	
        	release1 = Math.max(release1, hold1 + tmp);
        	hold1 = Math.max(hold1, -tmp);
        }
        
        return release2;
    }
}
