package binaryTreeMaximumPathSum;

import entity.TreeNode;

public class Solution {
	private int result;
	public int maxPathSum(TreeNode root) {
		result = Integer.MIN_VALUE;
		solve(root);
		
        return result;
    }
	
	private int solve(TreeNode node){
		if(node == null) return 0;
		
		int left = Math.max(0, solve(node.left));
		int right = Math.max(0, solve(node.right));
		
		result = Math.max(result, left + right + node.val);
		
		return Math.max(left, right) + node.val;
	}
}
