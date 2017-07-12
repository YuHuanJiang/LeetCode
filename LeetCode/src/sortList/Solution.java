package sortList;

import entity.ListNode;

public class Solution {
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode mid = head;
        ListNode pos = mid.next;
        
        while(pos != null) {
        	pos = pos.next;
        	if(pos != null) {
        		pos = pos.next;
        		mid = mid.next;
        	}
        }
        
        ListNode node = sortList(mid.next);
        mid.next = null;
        
        return merge(sortList(head), node);
    }

	private ListNode merge(ListNode sortList, ListNode node) {
		ListNode rear, head;
		rear = head = new ListNode(-1);
		
		while(sortList != null && node != null) {
			if(sortList.val <= node.val) {
				rear.next = sortList;
				rear = sortList;
				sortList = sortList.next;
			} else {
				rear.next = node;
				rear = node;
				node = node.next;
			}
		}
		
		if(sortList != null) rear.next = sortList;
		else rear.next = node;
		
		return head.next;
	}
}
