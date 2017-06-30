package distinctSubsequences;

public class Solution {
	public int numDistinct(String s, String t) {
		int sLen = s.length();
		int tLen = t.length();
		
        int[][] dp = new int[tLen + 1][sLen + 1];
        dp[0][0] = 1;
        for(int i = 1; i < tLen; i++) dp[i][0] = 0;
        
        for(int j = 1; j < sLen; j++) dp[0][j] = 1;
        
        for(int i = 1; i <= tLen; i++) {
        	for(int j = 1; j <= sLen; j++) {
        		dp[i][j] = dp[i][j - 1];
        		if(s.charAt(j - 1) == t.charAt(i - 1)) dp[i][j] += dp[i - 1][j - 1];
        	}
        }
        
        return dp[tLen][sLen];
    }
}
