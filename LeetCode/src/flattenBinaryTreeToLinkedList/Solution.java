package flattenBinaryTreeToLinkedList;

import entity.TreeNode;

public class Solution {
	public void flatten(TreeNode root) {
        TreeNode head = new TreeNode(-1);
        head.right = root;
        TreeNode node = head;
        TreeNode end;
        TreeNode tmp;
        
        while(node.right != null) {
        	node = node.right;
        	
        	if(node.left != null){
        		end = node.left;
        		while(end.right != null) end = end.right;
        		
        		tmp = node.right;
        		node.right = node.left;
        		node.left = null;
        		end.right = tmp;
        	}
        }
        
        head.right = null;
    }
}
