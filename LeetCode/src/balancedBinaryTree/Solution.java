package balancedBinaryTree;

import entity.TreeNode;

public class Solution {
	public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        
        if(Math.abs(left - right) > 1) return false;
        else return isBalanced(root.left) && isBalanced(root.right);
    }
	
	private int getHeight(TreeNode node){
		if(node == null) return 0;
		
		if(node.left == null && node.right == null) return 1;
		else {
			int left = getHeight(node.left);
			int right = getHeight(node.right);
			
			return 1 + (left > right ? left : right);
		}
	}
}
