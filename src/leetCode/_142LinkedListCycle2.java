package leetCode;

/*
 * Link : https://leetcode.com/problems/linked-list-cycle-ii/
 */

public class _142LinkedListCycle2 {
	public static ListNode detectCycle(ListNode head) {
		ListNode fastPointer=head;
		ListNode slowPointer=head;
		while(fastPointer!=null && fastPointer.next!=null)
		{
			fastPointer=fastPointer.next.next;
			slowPointer=slowPointer.next;
			if(fastPointer==slowPointer)
			{
				break;
			}
		}
		
		if(fastPointer==null || fastPointer.next==null)
			return null;
		slowPointer=head;
		while(fastPointer!=slowPointer){
			slowPointer=slowPointer.next;
			fastPointer=fastPointer.next;
		}
		return fastPointer;
	}


	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {

	}
}