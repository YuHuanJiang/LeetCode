package constructBinaryTreeFromInorderAndPostorderTraversal;

import entity.TreeNode;

public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        
        return solve(inorder, 0, inLen - 1, postorder, 0, postLen - 1);
    }
	
	private TreeNode solve(int[] inorder, int inStar, int inEnd, int[] postorder, int postStar, int postEnd){
		if(inStar > inEnd || postStar > postEnd) return null;
		int rootValue = postorder[postEnd];
		int rootIndex = 0;
		
		for(int i = inStar; i <= inEnd; i++) {
			if(inorder[i] == rootValue) {
				rootIndex = i;
				break;
			}
		}
		
		TreeNode root = new TreeNode(rootValue);
		root.left = solve(inorder, inStar, rootIndex - 1, postorder, postStar, postStar + rootIndex - (inStar + 1));
		root.right = solve(inorder, rootIndex + 1, inEnd, postorder, postStar + rootIndex - inStar, postEnd - 1);
		return root;
	}
}
