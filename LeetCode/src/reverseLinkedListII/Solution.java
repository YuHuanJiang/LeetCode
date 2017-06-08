package reverseLinkedListII;

import entity.ListNode;

public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode root = new ListNode(0);
        ListNode p = root;
        root.next = head;

        for (int i = 1; i < m && p != null; i++) p = p.next;

        if (p != null) {
            ListNode q = p.next;
            ListNode r;

            if (m < 1) m = 1;

            n = n - m + 1;
            for (int i = 1; i < n && q.next != null; i++) {
                r = q.next;

                q.next = r.next;
                r.next = p.next;
                p.next = r;
            }

            head = root.next;
        }

        return head;
    }
}
