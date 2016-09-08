package LeetCodePerformancePractice;

public class _143ReorderList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(3);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(0);
		ln.next.next.next=new ListNode(-4);
		ln.next.next.next.next=ln.next;
		System.out.println(detectCycle(ln));

	}
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
}
