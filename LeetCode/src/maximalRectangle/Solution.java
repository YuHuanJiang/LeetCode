package maximalRectangle;

import java.util.LinkedList;

public class Solution {
	private final static char collect_point = '1';
	public int maximalRectangle(char[][] matrix) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
		
		int row = matrix.length;
		int col = matrix[0].length;
		int max = 0;
		int[] height = new int[col];
		for(int i=0; i < row ;i++){
			for(int j = 0; j < col;j++){
				if(matrix[i][j] == collect_point) height[j] += 1;
				else height[j] = 0;
			}
			max = Math.max(largestRectangleArea(height),max);
		}
		return max;
    }
	
	private int largestRectangleArea(int[] heights) {
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
