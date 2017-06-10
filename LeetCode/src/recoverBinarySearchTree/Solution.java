package recoverBinarySearchTree;

import entity.TreeNode;

public class Solution {
	TreeNode pre, p, q;

    public void recoverTree(TreeNode root) {
        pre = p = q = null;
        dfs(root);
        int tmp = p.val;
        p.val = q.val;
        q.val = tmp;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null && pre.val > root.val) {
            if (p == null) p = pre;
            q = root;
        }

        pre = root;
        dfs(root.right);
    }
}
