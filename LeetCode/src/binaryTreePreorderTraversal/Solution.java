package binaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

import entity.TreeNode;

public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        solve(root, result);
        return result;
    }
	
	private void solve(TreeNode node, List<Integer> list) {
		if(node != null) {
			list.add(node.val);
			solve(node.left, list);
			solve(node.right, list);
		}
	}
}
