package PracticeLeetCode;

public class _141LinkedListCycle {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {

	}
	public boolean hasCycle(ListNode head) {
		if(head==null||head.next==null)
			return false;
		ListNode fastPointer=head.next.next;
		ListNode slowPointer=head;
		while(fastPointer!=null && slowPointer!=null)
		{
			if(fastPointer==slowPointer)
				return true;
			fastPointer=fastPointer.next;
			if(fastPointer!=null)
				fastPointer=fastPointer.next;
			slowPointer=slowPointer.next;
		}
		return false;
	}
}