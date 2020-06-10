package PracticeLeetCode;

public class _083RemoveDuplicatesSortedList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static void main(String[] args) {
		ListNode ln = new ListNode(1);
		ln.next = new ListNode(1);
		ln.next.next = new ListNode(2);
		ln = deleteDuplicates(ln);
		while(ln != null)
		{
			System.out.println(ln.val);
			ln = ln .next;
		}
		ln = new ListNode(1);
		ln.next = new ListNode(1);
		ln.next.next = new ListNode(2);
		ln.next.next.next = new ListNode(3);
		ln.next.next.next.next = new ListNode(3);
		ln = deleteDuplicates(ln);
		while(ln != null)
		{
			System.out.println(ln.val);
			ln = ln .next;
		}
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
		{
			return head;
		}
		ListNode ln = new ListNode(-1);
		ListNode op = ln;
		Integer prevVal = null;
		while(head != null)
		{
			int currVal = head.val;
			if(prevVal == null || currVal != prevVal)
			{
				ln.next = new ListNode(currVal);
				prevVal = currVal;
				ln = ln.next;
			}
			head = head.next;
		}
		return op.next;
	}

}
