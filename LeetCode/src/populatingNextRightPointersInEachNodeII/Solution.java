package populatingNextRightPointersInEachNodeII;

import java.util.LinkedList;

import entity.TreeLinkNode;

public class Solution {
	public void connect(TreeLinkNode root) {
		if(root == null) return;
		
		LinkedList<TreeLinkNode> nodes = new LinkedList<>();
		nodes.add(root);
		int size = 1;
		TreeLinkNode node;
		
		while(!nodes.isEmpty()) {
			node = nodes.poll();
			size--;
			
			if(node.left != null) nodes.add(node.left);
			if(node.right != null) nodes.add(node.right);
			
			if(size > 0) node.next = nodes.getFirst();
			else size = nodes.size();
		}
	}
}
