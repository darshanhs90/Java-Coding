package May2021GoogLeetcode;

public class _0369PlusOneLinkedList {
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
		printNodes(plusOne(ln));

		ln = new ListNode(9);
		printNodes(plusOne(ln));
	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode plusOne(ListNode head) {
		if (head == null)
			return head;

		ListNode reverse = reverseLL(head);
		ListNode reversePtr = reverse;
		printNodes(reverse);
		boolean hasCarry = true;
		ListNode prev = null;
		while (reverse != null) {
			if (hasCarry) {
				hasCarry = false;
				int sum = reverse.val + 1;
				if (sum > 9) {
					hasCarry = true;
					sum = sum - 10;
				}
				reverse.val = sum;
			}
			prev = reverse;
			reverse = reverse.next;
		}

		if (hasCarry) {
			prev.next = new ListNode(1);
		}

		return reverseLL(reversePtr);
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
