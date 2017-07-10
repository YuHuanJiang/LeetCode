package wordBreakII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String>[] dp = new ArrayList[s.length() + 1];
		dp[0] = new ArrayList<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(dp[i] == null) continue;
			for(String word : wordDict) {
				int len = word.length();
				int end = i + len;
				if(end > s.length()) continue;
				
				if(s.substring(i, end).equals(word)) {
					if(dp[end] == null) dp[end] = new ArrayList<>();
					dp[end].add(word);
				}
			}
		}
		
		List<String> result = new ArrayList<>();
		if(dp[s.length()] == null) return result;
		List<String> tmp = new ArrayList<>();
		solve(dp, s.length(), result, tmp);
		
        return result;
	}
	
	private void solve(List<String>[] dp, int end, List<String> result, List<String> tmp) {
		if(end <= 0) {
			StringBuffer s = new StringBuffer();
			s.append(tmp.get(tmp.size() - 1));
			for(int i = tmp.size() - 2; i >= 0; i--) {
				s.append(' ');
				s.append(tmp.get(i));
			}
			result.add(s.toString());
			return;
		}
		
		for(String str : dp[end]) {
			tmp.add(str);
			solve(dp, end - str.length(), result, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}
}
