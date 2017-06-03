package minimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public String minWindow(String s, String t) {
        if(s == null || "".equals(s)) return "";
        String result = "";
        Map<Character, Integer> container = new HashMap<>();
        int sLength = s.length();
        int tLength = t.length();
        char ch;
        for(int i = 0; i < tLength; i++) {
        	ch = t.charAt(i);
        	if(container.containsKey(ch)) container.put(ch, container.get(ch) + 1);
        	else container.put(ch, 1);
        }
        
        int count = 0, pre = 0;
        int minLen = sLength + 1;
        
        for(int i = 0; i < sLength; i++){
        	ch = s.charAt(i);
        	if(container.containsKey(ch)) {
        		container.put(ch, container.get(ch) - 1);
        		if(container.get(ch) >= 0) count++;
        		
        		while(count == tLength) {
        			ch = s.charAt(pre);
        			if(container.containsKey(ch)) {
        				container.put(ch, container.get(ch) + 1);
        				
        				if(container.get(ch) > 0) {
        					if(minLen > i - pre + 1){
        						result = s.substring(pre, i + 1);
        						minLen = i - pre + 1;
        					}
        					count--;
        				}
        			}
        			pre++;
        		}
        	}
        }
        return result;
    }
}
