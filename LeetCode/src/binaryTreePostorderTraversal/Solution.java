package binaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

import entity.TreeNode;

public class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        solve(root, result);
        return result;
    }
	
	private void solve(TreeNode node, List<Integer> list){
		if(node != null) {
			solve(node.left, list);
			solve(node.right, list);
			list.add(node.val);
		}
	}
}
