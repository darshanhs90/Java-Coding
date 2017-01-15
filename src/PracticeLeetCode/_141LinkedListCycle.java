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
		if(head==null|head.next==null)
			return true;
		ListNode forward=head.next.next;
		while(head!=null && forward!=null)
		{
			if(head==forward)
				return true;
			head=head.next;
			forward=forward.next;
			if(forward==null)
				break;
			forward=forward.next;
		}
		return false;
	}
}