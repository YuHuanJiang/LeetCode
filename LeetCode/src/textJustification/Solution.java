package textJustification;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	private static final char placeholder = ' ';
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<String>();
        if(words == null || words.length == 0) return result;
        
        int length = words.length;
        int left = 0;
        int right = length;
        int len;
        int next;
        StringBuffer line;
        
        while(left < right){
        	len = words[left].length();
        	next = left + 1;
        	
        	while(next < right && len + 1 + words[next].length() <= maxWidth)
        		len += 1 + words[next++].length();
        	
        	line = new StringBuffer(words[left]);
        	
        	if(next == right){
        		for(int k = left + 1; k < right; k++) {
        			line.append(placeholder);
        			line.append(words[k]);
        		}
        		
        		while(line.length() < maxWidth) line.append(placeholder);
        	} else {
        		int ext = maxWidth - len;
        		int num = next - left - 1;
        		
        		if(num == 0) {
        			while(line.length() < maxWidth) line.append(placeholder);
        		} else {
        			for(int k = left + 1; k < next	; k++){
        				line.append(placeholder);
        				for(int p = 0; p < ext / num; p++) line.append(placeholder);
        				
        				if(k - left <= ext % num) line.append(placeholder);
        				
        				line.append(words[k]);
        			}
        		}
        	}
        	
        	result.add(line.toString());
        	line = null;
        	
        	left = next;
        }
        
        return result;
    }
}
