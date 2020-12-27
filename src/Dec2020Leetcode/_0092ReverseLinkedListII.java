package Dec2020Leetcode;

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
		ListNode ln = new ListNode();
		ListNode lnPtr = ln;
		ln.next = head;
		int count = 1;
		while (count < m) {
			ln = ln.next;
			count++;
		}

		ListNode leftPart = ln;

		ListNode middlePart = ln.next;
		while (count <= n) {
			ln = ln.next;
			count++;
		}

		ListNode rightPart = ln.next;
		ln.next = null;

		middlePart = reverseLL(middlePart);

		leftPart.next = middlePart;
		while (leftPart != null && leftPart.next != null) {
			leftPart = leftPart.next;
		}
		leftPart.next = rightPart;
		return lnPtr.next;
	}

	public static ListNode reverseLL(ListNode ln) {
		if (ln == null || ln.next == null)
			return ln;
		ListNode nextNode = ln.next;
		ListNode newHead = reverseLL(ln.next);
		nextNode.next = ln;
		ln.next = null;
		return newHead;
	}
}
