package April2021Leetcode;

public class _0142LinkedListCycleII {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		ListNode ln = new ListNode(3);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(0);
		ln.next.next.next = new ListNode(-4);
		ln.next.next.next.next = ln.next;
		ln = detectCycle(ln);
		System.out.println(ln != null ? ln.val : "null");

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = ln;
		ln = detectCycle(ln);
		System.out.println(ln != null ? ln.val : "null");

		ln = new ListNode(1);
		ln = detectCycle(ln);
		System.out.println(ln != null ? ln.val : "null");
	}

	public static ListNode detectCycle(ListNode head) {
		
	}

}
