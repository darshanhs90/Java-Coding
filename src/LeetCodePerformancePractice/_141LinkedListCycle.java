package LeetCodePerformancePractice;

public class _141LinkedListCycle {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {

	}
	public boolean hasCycle(ListNode head) {
		ListNode fastPointer=head;
		ListNode slowPointer=head;
		if(head!=null &&head.next!=null)
		{
			slowPointer=head;
			fastPointer=head.next.next;
			while(fastPointer!=null)
			{
				if(slowPointer==fastPointer)
					return true;
				fastPointer=fastPointer.next;
				if(fastPointer==null)
					return false;
				fastPointer=fastPointer.next;
				slowPointer=slowPointer.next;
			}
		}
		return false;
	}
}
