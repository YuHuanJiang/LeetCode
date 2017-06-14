package convertSortedArrayToBinarySearchTree;

import entity.TreeNode;

public class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        
        return solve(nums, 0, nums.length - 1);
    }
	
	private TreeNode solve(int[] nums, int star, int end){
		if(star > end) return null;
		
		int mid = (star + end) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = solve(nums, star, mid - 1);
		node.right = solve(nums, mid + 1, end);
		
		return node;
	}
}
