package PracticeLeetCode;

public class _203RemoveLinkedListElements {

	static public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {
		ListNode ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(6);
		ln.next.next.next = new ListNode(3);
		ln.next.next.next.next = new ListNode(4);
		ln.next.next.next.next.next = new ListNode(5);
		ln.next.next.next.next.next.next = new ListNode(6);
		ln = removeElements(ln, 11);
		while(ln!=null)
		{
			System.out.println(ln.val);
			ln= ln.next;
		}
	}
	// -1 -> 1 -> 2
	public static ListNode removeElements(ListNode head, int val) {
		ListNode ln = new ListNode(-1);
		ListNode op = ln;

		while(head!=null)
		{
			if(head.val != val) {
				ln.next = head;
				ln = ln.next;
			}
			head = head.next;
		}
		if(ln != null)
			ln.next = null;
		return op.next;
	}

}