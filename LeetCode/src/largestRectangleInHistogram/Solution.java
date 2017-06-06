package largestRectangleInHistogram;

import java.util.LinkedList;

public class Solution {
	public int largestRectangleArea(int[] heights) {
		if(heights == null || heights.length == 0) return 0;
		if(heights.length == 1) return heights[0];
		
        LinkedList<Integer> stack = new LinkedList<>();
        int length = heights.length;
        int result = 0, i = 0, tmp;

        while(i <= length){
        	tmp = i== length ? 0 : heights[i];
        	
        	if(stack.isEmpty() || heights[stack.getLast()] <= tmp) stack.addLast(i++);
        	else result = Math.max(result, heights[stack.removeLast()] * (stack.isEmpty() ? i : i - 1 - stack.getLast()));
        }
        
        return result;
    }
}
