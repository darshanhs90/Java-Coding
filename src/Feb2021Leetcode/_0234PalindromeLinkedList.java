package Feb2021Leetcode;

public class _0234PalindromeLinkedList {

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
		ln.next.next.next.next.next = new ListNode(6);
		ln.next.next.next.next.next.next = new ListNode(7);
		System.out.println(isPalindrome(ln));

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(3);
		ln.next.next.next.next.next = new ListNode(2);
		ln.next.next.next.next.next.next = new ListNode(1);
		System.out.println(isPalindrome(ln));

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(2);
		ln.next.next.next = new ListNode(1);
		System.out.println(isPalindrome(ln));

		ln = new ListNode(1);
		ln.next = new ListNode(1);
		System.out.println(isPalindrome(ln));

		ln = new ListNode(1);
		ln.next = new ListNode(1);
		ln.next.next = new ListNode(2);
		ln.next.next.next = new ListNode(1);
		System.out.println(isPalindrome(ln));

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(1);
		System.out.println(isPalindrome(ln));

	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		int length = getLength(head);
		if (length % 2 == 0) {
			ListNode slow = head;
			ListNode fast = head;
			ListNode prev = null;
			while (fast != null && fast.next != null) {
				prev = slow;
				slow = slow.next;
				fast = fast.next;
				fast = fast.next;
			}

			ListNode nextPart = slow;
			if (prev != null)
				prev.next = null;

			ListNode reverse = reverseLL(nextPart);

			while (head != null && reverse != null) {
				if (head.val != reverse.val)
					return false;
				head = head.next;
				reverse = reverse.next;
			}
		} else {
			ListNode slow = head;
			ListNode fast = head;
			ListNode prev = null;
			while (fast != null && fast.next != null) {
				prev = slow;
				slow = slow.next;
				fast = fast.next;
				fast = fast.next;
			}

			ListNode nextPart = slow.next;
			if (prev != null)
				prev.next = null;

			ListNode reverse = reverseLL(nextPart);

			while (head != null && reverse != null) {
				if (head.val != reverse.val)
					return false;
				head = head.next;
				reverse = reverse.next;
			}
		}
		return true;
	}

	public static int getLength(ListNode head) {
		if (head == null)
			return 0;
		return 1 + getLength(head.next);
	}

	public static ListNode reverseLL(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode nextNode = head.next;
		ListNode reverseNode = reverseLL(head.next);
		nextNode.next = head;
		head.next = null;
		return reverseNode;
	}

}
