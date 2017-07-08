package palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<String>> partition(String s) {		
		List<List<String>> result = new ArrayList<>();
		if(s == null || s.length() == 0) return result;
		
		List<String> sub = new ArrayList<>();
        
		solve(s, 0, sub, result);
		return result;
    }
	
	private void solve(String str, int start, List<String> sub, List<List<String>> result){
		if(start == str.length()) {
			result.add(new ArrayList<>(sub));
			return;
		}
		
		for(int i = start; i < str.length(); i++) {
			String tmp = str.substring(start, i + 1);
			if(isPalindrome(tmp)) {
				sub.add(tmp);
				solve(str, i + 1, sub, result);
				sub.remove(sub.size() - 1);
			}
		}
	}
	
	private boolean isPalindrome(String str){
		int low = 0, high = str.length() - 1;
		
		while(low < high) {
			if(str.charAt(low) != str.charAt(high)) return false;
			low++;
			high--;
		}
		
		return true;
	}
}
