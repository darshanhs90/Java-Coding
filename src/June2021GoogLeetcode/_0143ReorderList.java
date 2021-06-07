package June2021GoogLeetcode;

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
		ListNode mid = reverseLL(getMid(head));
		ListNode op = new ListNode();
		ListNode opPtr = op;

		while (head != null || mid != null) {
			if (head != null) {
				op.next = head;
				op = op.next;
				head = head.next;
			}

			if (mid != null) {
				op.next = mid;
				op = op.next;
				mid = mid.next;
			}
		}

		if (op != null)
			op.next = null;
		head = opPtr.next;
	}

	public static ListNode reverseLL(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode nextNode = head.next;
		ListNode rev = reverseLL(head.next);
		nextNode.next = head;
		head.next = null;
		return rev;
	}

	public static ListNode getMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		if (prev != null)
			prev.next = null;
		return slow;
	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}
}
