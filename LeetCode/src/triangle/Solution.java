package triangle;

import java.util.List;

public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        
        if(length == 0) return length;
        List<Integer> sum = triangle.get(length - 1);
        if(length == 1) return sum.get(0);
        
        List<Integer> array;
        int tmp;
        
        for(int i = length - 2; i >= 0; i--) {
        	array = triangle.get(i);
        	for(int j = 0; j < array.size(); j++) {
        		tmp = (sum.get(j) > sum.get(j + 1) ? sum.get(j + 1) : sum.get(j)) + array.get(j);
        		sum.set(j, tmp);
        	}
        }
        
        return sum.get(0);
    }
}
