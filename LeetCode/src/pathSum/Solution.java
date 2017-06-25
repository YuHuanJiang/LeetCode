package pathSum;

import entity.TreeNode;

public class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        
        if(root.left == null && root.right == null && sum == root.val) return true;
        else {
        	int tmp = sum - root.val;
        	return hasPathSum(root.left, tmp) || hasPathSum(root.right, tmp);
        }
    }
}
