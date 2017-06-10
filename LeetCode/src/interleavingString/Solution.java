package interleavingString;

public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null) return false;
        if(s1.length() + s2.length() != s3.length()) return false;
        int len1 = s1.length() + 1, len2 = s2.length() + 1;
        
        boolean[][] dp = new boolean[len1][len2];
        dp[0][0] = true;
        int i;
        for(i = 1; i < len1; i++) {
        	if(s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0]) dp[i][0] = true;
        }
        
        for(i = 1; i < len2; i++) {
        	if(s2.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1]) dp[0][i] = true;
        }
        
        for(i = 1; i < len1; i++) {
        	for(int j = 1; j < len2; j++) {
        		if(s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) dp[i][j] = true;
        		if(s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]) dp[i][j] = true;
        	}
        }
        
        return dp[s1.length()][s2.length()];
    }
}
