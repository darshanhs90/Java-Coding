package May2021Leetcode;

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
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode removeElements(ListNode head, int val) {
		ListNode op = new ListNode();
		ListNode opPtr = op;

		while (head != null) {
			if (head.val != val) {
				op.next = head;
				op = op.next;
			}
			head = head.next;
		}
		op.next = null;
		return opPtr.next;
	}

}
