package partitionList;

import entity.ListNode;

public class Solution {
	public ListNode partition(ListNode head, int x) {
		ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        ListNode node = head, next, less = lessHead, greater = greaterHead;
        
        while (node != null) {
            next = node.next;
            if (node.val < x) {
                less.next = node;
                less = less.next;
                less.next = null;
            } else {
                greater.next = node;
                greater = greater.next;
                greater.next = null;
            }
            node = next;
        }
        
        less.next = greaterHead.next;
        return lessHead.next;
    }
}
