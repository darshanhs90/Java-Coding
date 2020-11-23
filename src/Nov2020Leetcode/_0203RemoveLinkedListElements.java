package Nov2020Leetcode;

public class _0203RemoveLinkedListElements {
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
		ln.next.next = new ListNode(6);
		ln.next.next.next = new ListNode(3);
		ln.next.next.next.next = new ListNode(4);
		ln.next.next.next.next.next = new ListNode(5);
		ln.next.next.next.next.next.next = new ListNode(6);
		ListNode op = removeElements(ln, 1);
		printElements(op);
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(6);
		ln.next.next.next = new ListNode(3);
		ln.next.next.next.next = new ListNode(4);
		ln.next.next.next.next.next = new ListNode(5);
		ln.next.next.next.next.next.next = new ListNode(6);
		op = removeElements(ln, 2);
		printElements(op);
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(6);
		ln.next.next.next = new ListNode(3);
		ln.next.next.next.next = new ListNode(4);
		ln.next.next.next.next.next = new ListNode(5);
		ln.next.next.next.next.next.next = new ListNode(6);
		op = removeElements(ln, 6);
		printElements(op);
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(6);
		ln.next.next.next = new ListNode(3);
		ln.next.next.next.next = new ListNode(4);
		ln.next.next.next.next.next = new ListNode(5);
		ln.next.next.next.next.next.next = new ListNode(6);
		op = removeElements(ln, 3);
		printElements(op);
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(6);
		ln.next.next.next = new ListNode(3);
		ln.next.next.next.next = new ListNode(4);
		ln.next.next.next.next.next = new ListNode(5);
		ln.next.next.next.next.next.next = new ListNode(6);
		op = removeElements(ln, 4);
		printElements(op);
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(6);
		ln.next.next.next = new ListNode(3);
		ln.next.next.next.next = new ListNode(4);
		ln.next.next.next.next.next = new ListNode(5);
		ln.next.next.next.next.next.next = new ListNode(6);
		op = removeElements(ln, 5);
		printElements(op);
		System.out.println();

	}

	public static void printElements(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "/");
			head = head.next;
		}
	}

	/*
	 * Recursive public static ListNode removeElements(ListNode head, int val) { if
	 * (head == null) return null; head.next = removeElements(head.next, val);
	 * return head.val == val ? head.next : head; }
	 */

	// Iterative
	public static ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		ListNode op = new ListNode(-1);
		op.next = head;

		ListNode curr = head, prev = op;
		while (curr != null) {
			if (curr.val == val) {
				prev.next = curr.next;
				curr = curr.next;
			} else {
				prev.next = curr;
				prev = prev.next;
				curr = curr.next;
			}
		}
		return op.next;
	}

}
