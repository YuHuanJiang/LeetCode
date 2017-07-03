package sumRootToLeafNumbers;

import entity.TreeNode;

public class Solution {
	private int sum;
	
	public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        
        solve(root, 0);
        
        return sum;
    }
	
	private void solve(TreeNode node, int sum){
		sum = 10 * sum + node.val;
		
		if(node.left == null && node.right == null) this.sum += sum;
		
		if(node.left != null) solve(node.left, sum);
		if(node.right != null) solve(node.right, sum);
	}
}
