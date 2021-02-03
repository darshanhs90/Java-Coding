package Jan2021Leetcode;

public class _0025ReverseNodesInKGroup {
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
		ln = reverseKGroup(ln, 3);
		printNodes(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(5);
		ln = reverseKGroup(ln, 2);
		printNodes(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(5);
		ln = reverseKGroup(ln, 1);
		printNodes(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(5);
		ln = reverseKGroup(ln, 4);
		printNodes(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(5);
		ln = reverseKGroup(ln, 5);
		printNodes(ln);

		ln = new ListNode(1);
		ln = reverseKGroup(ln, 1);
		printNodes(ln);
	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println("****************");
	}

	// Iterative
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1)
			return head;
		ListNode op = new ListNode();
		ListNode opPtr = op;
		op.next = head;
		ListNode prev = null;
		while (head != null) {
			int count = 1;
			ListNode leftPart = prev == null ? op : prev;
			while (count < k && head.next != null) {
				head = head.next;
				count++;
			}

			if (count != k) {
				return opPtr.next;
			}

			ListNode midPart = leftPart.next;
			leftPart.next = null;

			ListNode rightPart = head != null ? head.next : null;

			if (head != null)
				head.next = null;
			midPart = reverseLL(midPart);

			leftPart.next = midPart;
			prev = null;
			while (leftPart != null) {
				prev = leftPart;
				leftPart = leftPart.next;
			}

			prev.next = rightPart;
			head = rightPart;
		}
		return opPtr.next;
	}

	public static ListNode reverseLL(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode nextNode = head.next;
		ListNode reverseNode = reverseLL(head.next);
		head.next = null;
		nextNode.next = head;
		return reverseNode;
	}
}
