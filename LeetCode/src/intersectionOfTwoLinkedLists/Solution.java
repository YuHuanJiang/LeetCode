package intersectionOfTwoLinkedLists;

import entity.ListNode;

public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode t_a = headA, t_b = headB;
        
        while(t_a != t_b) {
        	t_a = (t_a != null) ? t_a.next : headB;
        	t_b = (t_b != null) ? t_b.next : headA;
        }
        
        return t_a;
        
    }
}
