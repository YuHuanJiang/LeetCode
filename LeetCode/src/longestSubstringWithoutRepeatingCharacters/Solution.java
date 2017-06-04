package longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
        if(s == null || "".equals(s)) return 0;
        
        int start = 0;
        int result = 0;
        int length = s.length();
        Map<Character, Integer> container = new HashMap<>(length);
        char ch;
        
        for (int i = 0; i < length; i++) {
            ch = s.charAt(i);
            if (container.containsKey(ch) && container.get(ch) >= start) start = container.get(ch) + 1;
            else result = Math.max(result, i - start + 1);

            container.put(ch, i);
        }
        
        return result;
    }
}
