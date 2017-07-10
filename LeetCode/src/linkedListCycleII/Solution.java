package linkedListCycleII;

import entity.ListNode;

public class Solution {
	public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
	    ListNode walker = head.next;
	    ListNode runner = head.next.next;
	    while(runner != null && walker != runner) {
	        walker = walker.next;
	        if(runner.next != null) runner = runner.next.next;
	        else runner = null;
	    }
	    if(runner == null) return null;
	    runner = head;
	    while(walker != runner) {
	        walker = walker.next;
	        runner = runner.next;
	    }
	    
	    return walker;
    }
}
