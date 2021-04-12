package April2021Leetcode;

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
		printNodes(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(5);
		reorderList(ln);
		printNodes(ln);

		ln = new ListNode(1);
		reorderList(ln);
		printNodes(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		reorderList(ln);
		printNodes(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		reorderList(ln);
		printNodes(ln);
	}

	public static void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

		ListNode slow = head;
		ListNode fast = head;
		ListNode leftPart = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null)
				fast = fast.next;
		}

		ListNode rightPart = slow.next;
		slow.next = null;
		rightPart = reverseLL(rightPart);

		ListNode op = new ListNode();
		ListNode opPtr = op;

		while (leftPart != null || rightPart != null) {
			if (leftPart != null) {
				op.next = leftPart;
				op = op.next;
				leftPart = leftPart.next;
			}

			if (rightPart != null) {
				op.next = rightPart;
				op = op.next;
				rightPart = rightPart.next;
			}
		}
		head = opPtr.next;
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

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}
}
