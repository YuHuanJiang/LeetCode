package wordBreak;

import java.util.List;

public class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return true;
        
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        
        for(int i = 0; i < length; i++) {
        	StringBuffer str = new StringBuffer(s.subSequence(0, i + 1));
        	
        	for(int j = 0; j <= i; j++) {
        		if(dp[j] && wordDict.contains(str.toString())) {
        			dp[i + 1] = true;
        			break;
        		}
        		str.deleteCharAt(0);
        	}
        }
        
        return dp[length];
    }
}
