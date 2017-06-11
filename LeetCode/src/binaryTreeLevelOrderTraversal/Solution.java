package binaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entity.TreeNode;

public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        LinkedList<TreeNode> level = new LinkedList<>();
        level.addLast(root);
        List<Integer> levelValues;
        TreeNode tmp;
        int i;
        
        while(!level.isEmpty()) {
        	levelValues = new ArrayList<>();
        	int length = level.size();
        	i = 0;
        	
        	while(i++ < length) {
        		tmp = level.removeFirst();
        		levelValues.add(tmp.val);
        		
        		if(tmp.left != null) level.addLast(tmp.left);
        		if(tmp.right != null) level.addLast(tmp.right);
        	}
        	
        	result.add(levelValues);
        }
        
        return result;
    }
}
