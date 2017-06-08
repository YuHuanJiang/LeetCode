package restoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	private final static char init = '0';
	private final static char filter = '.';
	private final static int star = 0;
	private final static int end = 255;
	
	public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) return result;
        
        solve(s, star, new String(), result);
        
        return result;
    }
	
	private void solve(String s, int star, String item, List<String> result){
		if(star == 3 && valid(s)) {
			result.add(item + s);
			return;
		}
		
		int length = s.length();
		for(int i = 0; i < 3 && i < length - 1; i++){
			String sub = s.substring(0, i + 1);
			if(valid(sub)) solve(s.substring(i + 1, length), star + 1, item + sub + filter, result);
		}
	}
	
	private boolean valid(String s){
		if(s.charAt(star) == init) return s.equals("0");
		
		int num = Integer.parseInt(s);
		
		return num <= end && num >= star;
	}
}
