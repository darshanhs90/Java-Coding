package LeetCodePractice;

public class _142LinkedListCycle2 {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static ListNode detectCycle(ListNode head) {
		ListNode fastPointer=head;
		ListNode slowPointer=head;
		while(fastPointer!=null)
		{	
			fastPointer=fastPointer.next;
			if(fastPointer!=null)
				fastPointer=fastPointer.next;
			slowPointer=slowPointer.next;
			if(fastPointer==slowPointer)
				break;
		}
		if(fastPointer==null)
			return null;
		slowPointer=head;
		while(fastPointer!=slowPointer){
			slowPointer=slowPointer.next;
			fastPointer=fastPointer.next;
		}
		return fastPointer;
	}
}

