package Leetcode2020Nov;

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
		// System.out.println(isPalindrome(ln));

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(3);
		ln.next.next.next.next.next = new ListNode(2);
		ln.next.next.next.next.next.next = new ListNode(1);
		// System.out.println(isPalindrome(ln));

		ln = new ListNode(1);
		ln.next = new ListNode(1);
		ln.next.next = new ListNode(2);
		ln.next.next.next = new ListNode(1);
		System.out.println(isPalindrome(ln));

	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
/
	public static boolean isPalindrome(ListNode head) {
		ListNode reverseNode = reverseLL(head);
		while (head != null && reverseNode != null) {
			System.out.println(head.val + "/" + reverseNode.val);
			if (head.val != reverseNode.val)
				return false;
			reverseNode = reverseNode.next;
			head = head.next;
		}
		return true;
	}

	public static ListNode reverseLL(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;
		ListNode newHead = reverseLL(head.next);
		next.next = head;
		head.next = null;
		return newHead;
	}
}
