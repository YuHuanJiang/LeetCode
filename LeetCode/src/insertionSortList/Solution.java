package insertionSortList;

import entity.ListNode;

public class Solution {
	public ListNode insertionSortList(ListNode head) {
		ListNode result = new ListNode(-1);
		ListNode node, tmp;
		
        while (head != null) {
            node = result;
            while (node.next != null && node.next.val < head.val) node = node.next;
            tmp = head.next;
            head.next = node.next;
            node.next = head;
            head = tmp;
        }

        return result.next;
    }
}
