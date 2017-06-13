package constructBinaryTreeFromPreorderAndInorderTraversal;

import entity.TreeNode;

public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        
        return solve(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
    }
	
	private TreeNode solve(int[] preorder, int preStar, int preEnd, int[] inorder, int inStar, int inEnd){
		if(preStar > preEnd || inStar > inEnd) return null;
		
		int rootValue = preorder[preStar];
		int rootIndex = 0;
		for(int i = inStar; i <= inEnd; i++) {
			if(inorder[i] == rootValue) {
				rootIndex = i;
				break;
			}
		}
		
		int len = rootIndex - inStar;
		TreeNode root = new TreeNode(rootValue);
		root.left = solve(preorder, preStar + 1, preStar+len, inorder, inStar, rootIndex-1);
		root.right = solve(preorder, preStar + len + 1, preEnd, inorder, rootIndex + 1, inEnd);
		
		return root;
	}
}
