package May2021Leetcode;

public class _0092ReverseLinkedListII {

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
		ln = reverseBetween(ln, 1, 4);
		printNodes(ln);
		System.out.println();

		ln = new ListNode(3);
		ln.next = new ListNode(5);
		ln = reverseBetween(ln, 1, 2);
		printNodes(ln);
	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;

		ListNode op = new ListNode();
		ListNode opPtr = op;
		op.next = head;

		// find left part
		int count = 1;
		ListNode leftPointer = op;
		while (count < m) {
			leftPointer = head;
			head = head.next;
			count++;
		}

		leftPointer.next = null;
		ListNode leftNode = head;

		while (count < n) {
			head = head.next;
			count++;
		}

		ListNode rightPart = head.next;
		head.next = null;
		ListNode reverseNode = reverseLL(leftNode);

		leftPointer.next = reverseNode;

		ListNode ln = leftPointer;
		while (ln != null && ln.next != null) {
			ln = ln.next;
		}
		ln.next = rightPart;

		return opPtr.next;
	}

	public static ListNode reverseLL(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode next = head.next;
		ListNode reverse = reverseLL(head.next);
		next.next = head;
		head.next = null;
		return reverse;
	}
}
