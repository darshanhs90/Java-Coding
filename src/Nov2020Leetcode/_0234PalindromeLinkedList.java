package Nov2020Leetcode;

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
		int count = 1;
		ListNode leftPart = new ListNode(-1);
		leftPart.next = head;
		ListNode leftPartPtr = leftPart;
		while (count < length / 2) {
			head = head.next;
			count++;
		}
		ListNode reverseNode;
		if (length % 2 == 0) {
			// find middle node
			ListNode nextNode = head.next;
			reverseNode = reverseLL(nextNode);
			head.next = null;
		} else {
			// discard middle node
			ListNode nextNode = head.next.next;
			reverseNode = reverseLL(nextNode);
			head.next = null;
		}
		ListNode forwardNode = leftPartPtr.next;
		while (forwardNode != null && reverseNode != null) {
			if (forwardNode.val != reverseNode.val)
				return false;
			forwardNode = forwardNode.next;
			reverseNode = reverseNode.next;
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
		ListNode next = head.next;
		ListNode newHead = reverseLL(head.next);
		next.next = head;
		head.next = null;
		return newHead;
	}
}
