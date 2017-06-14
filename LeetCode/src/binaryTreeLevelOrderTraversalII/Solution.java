package binaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entity.TreeNode;

public class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        
        LinkedList<TreeNode> level = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        level.addLast(root);
        TreeNode node;
        List<Integer> layout = new ArrayList<>();
        
        while(!level.isEmpty()) {
        	node = level.removeFirst();
        	if(node.left != null) next.addLast(node.left);
        	if(node.right != null) next.addLast(node.right);
        	
        	layout.add(node.val);
        	
        	if(level.isEmpty()) {
        		level = next;
        		next = new LinkedList<>();
        		result.addFirst(layout);
        		layout = new ArrayList<>();
        	}
        }
        
        return result;
    }
}
