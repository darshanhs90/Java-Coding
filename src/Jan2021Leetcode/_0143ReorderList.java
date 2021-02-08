package Jan2021Leetcode;

public class _0143ReorderList {
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
		reorderList(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(5);
		reorderList(ln);

		ln = new ListNode(1);
		reorderList(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		reorderList(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		reorderList(ln);

	}

	public static void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		int length = getLength(head);
		ListNode output = head;
		int count = 1;
		while (count <= length / 2) {
			head = head.next;
			count++;
		}

		ListNode rightPart = head.next;
		head.next = null;
		rightPart = reverseLL(rightPart);
		ListNode op = new ListNode();
		ListNode opPtr = op;

		while (output != null || rightPart != null) {
			if (output != null) {
				op.next = output;
				op = op.next;
				output = output.next;
			}

			if (rightPart != null) {
				op.next = rightPart;
				op = op.next;
				rightPart = rightPart.next;
			}
		}
		head = opPtr.next;
		printNodes(head);
	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode reverseLL(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode nextNode = head.next;
		ListNode reverseNode = reverseLL(head.next);
		nextNode.next = head;
		head.next = null;
		return reverseNode;
	}

	public static int getLength(ListNode head) {
		if (head == null)
			return 0;
		return 1 + getLength(head.next);
	}
}
