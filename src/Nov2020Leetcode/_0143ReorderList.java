package Nov2020Leetcode;

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

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	public static void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return;
		int length = getLength(head);
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode fakeHeadPtr = fakeHead;
		ListNode leftPart = head;
		int count = 1;
		while (count < (length / 2)) {
			head = head.next;
			count++;
		}

		ListNode rightPart = reverseLL(head.next);
		head.next = null;
		while (leftPart != null || rightPart != null) {
			if (leftPart != null) {
				fakeHead.next = leftPart;
				fakeHead = fakeHead.next;
				leftPart = leftPart.next;
			}
			fakeHead.next = rightPart;
			fakeHead = fakeHead.next;
			if (rightPart != null)
				rightPart = rightPart.next;
		}

		head = fakeHeadPtr.next;
		printNodes(head);
	}

	public static ListNode reverseLL(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode nextNode = head.next;
		ListNode newHead = reverseLL(nextNode);
		nextNode.next = head;
		head.next = null;
		return newHead;
	}

	public static int getLength(ListNode head) {
		if (head == null)
			return 0;
		return 1 + getLength(head.next);
	}
}
