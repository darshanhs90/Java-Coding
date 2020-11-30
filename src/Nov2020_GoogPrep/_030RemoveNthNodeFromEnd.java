package Nov2020_GoogPrep;

public class _030RemoveNthNodeFromEnd {
	static public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		ListNode ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(5);
		printNodes(removeNthFromEnd(ln, 2));

		ln = new ListNode(1);
		printNodes(removeNthFromEnd(ln, 1));

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		printNodes(removeNthFromEnd(ln, 1));
	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n == 0)
			return head;
		ListNode op = new ListNode();
		ListNode opPtr = op;
		op.next = head;
		ListNode slow = op;
		ListNode fast = op;
		while (n > 0) {
			fast = fast.next;
			n--;
		}
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return opPtr.next;
	}
}
