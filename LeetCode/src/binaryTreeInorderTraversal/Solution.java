package binaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entity.TreeNode;

public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        
        while(root != null || !stack.isEmpty()) {
        	while(root != null) {
        		stack.addLast(root);
        		root = root.left;
        	}
        	
        	if(!stack.isEmpty()) {
        		root = stack.removeLast();
        		result.add(root.val);
        		root = root.right;
        	}
        }
        
        return result;
	}
}
