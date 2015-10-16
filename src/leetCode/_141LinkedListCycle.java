package leetCode;

/*
 * Link : https://leetcode.com/problems/linked-list-cycle/
 */

public class _141LinkedListCycle {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		ListNode fastPointer=head;
		ListNode slowPointer=head;
		while(fastPointer!=null)
		{
			
			if(fastPointer.next!=null  && fastPointer.next.next!=null)
				fastPointer=fastPointer.next.next;
			else
				return false;
			if(slowPointer.next!=null)
				slowPointer=slowPointer.next;
			if(fastPointer.val==slowPointer.val)
				return true;
			
		}
		return false;
	}
}