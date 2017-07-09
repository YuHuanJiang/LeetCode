package candy;

import java.util.Arrays;

public class Solution {
	public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        
        int length = ratings.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        
        for(int i = 1; i < length; i++) {
        	if(ratings[i] > ratings[i - 1]) dp[i] = dp[i - 1] + 1;
        }
        
        for(int i = length - 2; i >= 0; i--) {
        	if(ratings[i] > ratings[i + 1] && dp[i] <= dp[i + 1]) dp[i] = dp[i + 1] + 1;
        }
        
        int result = 0;
        
        for(int i = 0; i < length; i++) result += dp[i];
        
        return result;
    }
}
