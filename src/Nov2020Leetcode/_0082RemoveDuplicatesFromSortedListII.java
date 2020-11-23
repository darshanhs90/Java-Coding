package Nov2020Leetcode;

public class _0082RemoveDuplicatesFromSortedListII {
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
		ln.next.next = new ListNode(2);
		ln.next.next.next = new ListNode(3);
		ln.next.next.next.next = new ListNode(3);
		ln.next.next.next.next.next = new ListNode(4);
		ln.next.next.next.next.next.next = new ListNode(4);
		ln.next.next.next.next.next.next.next = new ListNode(5);
		printNodes(deleteDuplicates(ln));
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(1);
		ln.next.next = new ListNode(1);
		ln.next.next.next = new ListNode(2);
		ln.next.next.next.next = new ListNode(3);
		ln.next.next.next.next.next = new ListNode(4);
		ln.next.next.next.next.next.next = new ListNode(5);
		printNodes(deleteDuplicates(ln));
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(1);
		ln.next.next = new ListNode(1);
		printNodes(deleteDuplicates(ln));
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(2);
		printNodes(deleteDuplicates(ln));
		System.out.println();

	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode fakeHead = new ListNode(-1);
		ListNode fakeHeadPtr = fakeHead;

		while (head != null) {
			if (head.next != null && head.val == head.next.val) {
				while (head != null && head.next != null && head.val == head.next.val) {
					head = head.next;
				}
				head = head != null ? head.next : null;
				fakeHead.next = null;
			} else {
				fakeHead.next = head;
				fakeHead = fakeHead.next;
				head = head.next;
			}
		}
		return fakeHeadPtr.next;
	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}
}
