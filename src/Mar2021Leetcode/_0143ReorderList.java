package Mar2021Leetcode;

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
		ListNode headPtr = head;

		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;

		while (fast != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next;
			if (fast != null)
				fast = fast.next;
		}

		ListNode secondPart = prev.next;
		prev.next = null;

		secondPart = reverseLL(secondPart);

		ListNode op = new ListNode();
		ListNode opPtr = op;

		while (headPtr != null || secondPart != null) {
			if (headPtr != null) {
				op.next = headPtr;
				headPtr = headPtr.next;
				op = op.next;
			}

			if (secondPart != null) {
				op.next = secondPart;
				secondPart = secondPart.next;
				op = op.next;
			}
		}

		head = opPtr.next;
		printNodes(head);

	}

	public static ListNode reverseLL(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode nextNode = head.next;
		ListNode reverseNode = reverseLL(nextNode);
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
