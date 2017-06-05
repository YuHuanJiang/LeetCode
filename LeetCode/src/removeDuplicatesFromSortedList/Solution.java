package removeDuplicatesFromSortedList;

import entity.ListNode;

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        
        ListNode pre = head;
        ListNode r = head.next;
        
        while(r != null) {
        	if(r.val == pre.val) pre.next = r.next;
        	else pre = r;
        	
        	r = r.next;
        }
        
        return head;
    }
}
