package decodeWays;

public class Solution {
	private final static char init = '0';
	private final static int star = 1;
	private final static int end = 26;
	
	public int numDecodings(String s) {
        if(s == null || "".equals(s)) return 0;
        
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        
        if(valid(s.substring(0, 1))) dp[1] = 1;
        else dp[1] = 0;
        
        for(int i = 2; i <= length; i++){
        	if(valid(s.substring(i - 1, i))) dp[i] += dp[i - 1];
        	if(valid(s.substring(i - 2, i))) dp[i] += dp[i - 2];
        }
        
        return dp[length];
    }
	
	private boolean valid(String s){
		if(s.charAt(0) == init) return false;
		
		int code = Integer.parseInt(s);
		
		return code >= star && code <= end;
	}
}
