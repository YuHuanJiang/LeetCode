package validPalindrome;

public class Solution {
	private static final int low1 = 'A', high1 = 'Z', low2 = '0', high2 = '9';
    
	public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        
        s = s.toUpperCase();
        
        int low = 0, high = s.length() - 1;
        char l, h;
        while(low < high) {
        	l = s.charAt(low);
        	h = s.charAt(high);
        	
        	if(isValid(l)) {
        		low++;
        		continue;
        	}
        	
        	if(isValid(h)) {
        		high--;
        		continue;
        	}
        	
        	if(l == h) {
        		low++;
        		high--;
        	} else return false;
        }
        
        return true;
    }
	
	private boolean isValid(char ch){
		return (ch < low1 || ch > high1) && (ch < low2 || ch > high2);
	}
}
