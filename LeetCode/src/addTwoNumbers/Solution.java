package addTwoNumbers;

import entity.ListNode;

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode root = l1;
        ListNode r = null;
        int carry = 0;
        int sum;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;

            r = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        r.next = l1 == null ? l2 : l1;

        if (carry == 1) {
            while (r.next != null) {
                sum = r.next.val + carry;
                r.next.val = sum % 10;
                carry = sum / 10;
                r = r.next;
            }

            if (carry == 1) r.next = new ListNode(1);
        }

        return root;
    }
}
