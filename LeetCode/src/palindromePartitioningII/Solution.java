package palindromePartitioningII;


public class Solution {
	public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int length = s.length();
        int[][] dp = new int[length][length];
        int[] tmp = new int[length + 1];
        
        for(int i = length -1; i >= 0; i--) {
        	tmp[i] = Integer.MAX_VALUE;
        	for(int j = i; j < length; j++) {
        		if(s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1] == 1)) {
        			dp[i][j] = 1;
        			tmp[i] = Math.min(1 + tmp[j + 1], tmp[i]);
        		}
        	}
        }
        
        return tmp[0] - 1;
    }
}
