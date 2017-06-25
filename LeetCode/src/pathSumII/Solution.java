package pathSumII;

import java.util.ArrayList;
import java.util.List;

import entity.TreeNode;

public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> line = new ArrayList<>();
		
		solve(result, root, sum, line);
		return result;
    }
	
	private void solve(List<List<Integer>> result, TreeNode node, int sum, List<Integer> line){
		if(node == null) return;
		
		line.add(node.val);
		sum -= node.val;
		
		if(node.left == null && node.right == null) {
			if(sum == 0) result.add(new ArrayList<>(line));
		} else {
			if(node.left != null) solve(result, node.left, sum, line);
			if(node.right != null) solve(result, node.right, sum, line);
		}
		
		line.remove(line.size() - 1);
	}
}
