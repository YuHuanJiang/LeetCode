package grayCode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        
        if (n >= 0) {
            result.add(0);
            int t = 1;
            for (int i = 0; i < n; i++) {
                for (int j = result.size() - 1; j >= 0; j--) result.add(result.get(j) ^ t);
                t <<= 1;
            }
        }
            
        return result;
    }
}
