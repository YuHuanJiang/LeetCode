package reorderList;

import entity.ListNode;

public class Solution {
	public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        ListNode mid = slow.next;
        ListNode last = mid;
        ListNode pre = null;
        ListNode next = null;
        while(last != null) {
        	next = last.next;
        	last.next = pre;
        	pre = last;
        	last = next;
        }
        
        slow.next = null;
        while(head != null && pre != null) {
        	next = head.next;
        	head.next = pre;
        	pre = pre.next;
        	head.next.next = next;
        	head = next;
        }
    }
}
