package uniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

import entity.TreeNode;

public class Solution {
	public List<TreeNode> generateTrees(int n) {
		if(n == 0) return new ArrayList<>();
		
        return solve(1, n);
    }
	
	private List<TreeNode> solve(int star, int end){
		List<TreeNode> result = new ArrayList<>();
		
		if(star > end) {
			result.add(null);
			return result;
		}
		
		for(int i = star; i <= end; i++) {
			List<TreeNode> left = solve(star, i - 1);
			List<TreeNode> right = solve(i + 1, end);
			
			for(TreeNode l : left) {
				for(TreeNode r : right) {
					TreeNode node = new TreeNode(i);
					node.left = l;
					node.right = r;
					result.add(node);
				}
			}
		}
		
		return result;
	}
}
