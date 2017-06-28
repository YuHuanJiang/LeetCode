package pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(numRows <= 0) return result;
        ArrayList<Integer> pre = new ArrayList<>();
        pre.add(1);
        result.add(pre);
        
        for(int i = 1; i < numRows; i++) {
        	ArrayList<Integer> array = new ArrayList<>();
        	array.add(1);
        	
        	for(int j = 0; j < i - 1; i++) array.add(pre.get(j) + pre.get(j + 1));
        	
        	array.add(1);
        	result.add(array);
        	pre = array;
        }
        
        return result;
    }
}
