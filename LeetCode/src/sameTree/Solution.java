package sameTree;

import entity.TreeNode;

public class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        return (p == null && q == null) || 
        		((p != null  && q != null && p.val == q.val) && 
        		(isSameTree(p.left, q.left) && isSameTree(p.right, q.right))); 
    }
}
