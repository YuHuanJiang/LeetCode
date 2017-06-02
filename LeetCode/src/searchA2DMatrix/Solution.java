package searchA2DMatrix;

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		
		int row = matrix.length;
		int col = matrix[0].length;
		int index;
		
		for(index = 0; index < row; index++){
			if(matrix[index][0] <= target && target <= matrix[index][col - 1]) break; 
		}
		
		if(index == row) return false;
		
		int left = 0;
		int right = col - 1;
		int mid;
		
		while(left <= right){
			mid = left + (right - left) / 2;
			if(target < matrix[index][mid]) right = mid - 1;
			else if(target > matrix[index][mid]) left = mid + 1;
			else return true;
		}
		
		return false;
    }
}
