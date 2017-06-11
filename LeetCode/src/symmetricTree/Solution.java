package symmetricTree;

import entity.TreeNode;

public class Solution {
	public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        else return valid(root.left, root.right);
    }
	
	private boolean valid(TreeNode left, TreeNode right){
		if(left == null && right == null) return true;
		else if((left != null && right == null ) || (right != null && left == null)) return false;
		else return left.val == right.val && valid(left.left, right.right) && valid(left.right, right.left);
	}
}
