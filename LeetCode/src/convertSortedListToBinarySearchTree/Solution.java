package convertSortedListToBinarySearchTree;

import entity.ListNode;
import entity.TreeNode;

public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode fast = head.next.next;
        ListNode mid = head;
        
        while (fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(mid.next.val);
        root.right = sortedListToBST(mid.next.next);
        ListNode midNext = mid.next;
        mid.next = null;
        root.left = sortedListToBST(head);
        mid.next = midNext;
        
        return root;
    }
}
