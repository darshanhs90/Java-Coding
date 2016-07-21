package LeetCodePractice;

public class _141LinkedListCycle {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static boolean hasCycle(ListNode head) {
		ListNode fastPointer=head;
		ListNode slowPointer=head;
		while(fastPointer!=null)
		{	
			fastPointer=fastPointer.next;
			if(fastPointer!=null)
				fastPointer=fastPointer.next;
			slowPointer=slowPointer.next;
			if(fastPointer==slowPointer && fastPointer!=null)
				return true;
		}
		return false;

	}
}

