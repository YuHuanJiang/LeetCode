package removeDuplicatesFromSortedListII;

import entity.ListNode;

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) return head;
		
        ListNode root = new ListNode(0);
        ListNode pre = root;
        boolean flag = false;
        
        while (head != null && head.next != null) {
            if (head.val == head.next.val) flag = true;
            else if (flag) flag = false;
            else {
                pre.next = head;
                pre = pre.next;
            }
            
            head = head.next;
        }
        
        if (!flag) {
            pre.next = head;
            pre = pre.next;
        } else pre.next = null;
        
        return root.next;
    }
}
