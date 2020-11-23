package Nov2020Leetcode;

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
		ln = reverseBetween(ln, 2, 4);
		printNodes(ln);
		System.out.println();

		ln = new ListNode(3);
		ln.next = new ListNode(5);
		ln = reverseBetween(ln, 1, 2);
		printNodes(ln);
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || m == n || m >= n)
			return head;
		ListNode fakeHead = new ListNode(-1);
		ListNode fakeHeadPtr = fakeHead;
		fakeHead.next = head;

		ListNode pre1 = null;
		ListNode curr1 = fakeHead;

		for (int i = 0; i < m ; i++) {
			pre1 = curr1;
			curr1 = curr1.next;
		}
		ListNode pre2 = pre1;
		ListNode curr2 = curr1;
		ListNode q2 = null;
		for (int i = 0; i <= n - m; i++) {
			q2 = curr2.next;
			curr2.next = pre2;
			pre2 = curr2;
			curr2 = q2;
		}

		pre1.next = pre2;
		curr1.next = curr2;

		return fakeHeadPtr.next;
	}

	public static ListNode reverseLL(ListNode ln) {
		if (ln == null || ln.next == null)
			return ln;
		ListNode nextNode = ln.next;
		ListNode newHEad = reverseLL(ln.next);
		nextNode.next = ln;
		ln.next = null;
		return newHEad;
	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}
}
