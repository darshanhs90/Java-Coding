package Feb2021Leetcode;

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
		ListNode headNode = head;
		ListNode prev = null;
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next;
			if (fast != null)
				fast = fast.next;
		}

		prev.next = null;

		ListNode reverseNode = reverseLL(slow);

		ListNode op = new ListNode();
		ListNode opPtr = op;
		head = headNode;
		while (head != null || reverseNode != null) {
			if (head != null) {
				op.next = head;
				op = op.next;
				head = head.next;
			}

			if (reverseNode != null) {
				op.next = reverseNode;
				op = op.next;
				reverseNode = reverseNode.next;
			}
		}

		head = opPtr.next;
		printNodes(head);
	}

	public static ListNode reverseLL(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode next = head.next;
		ListNode reverseNode = reverseLL(head.next);

		next.next = head;
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
