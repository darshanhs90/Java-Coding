package Jan2021Leetcode;

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
		

		ln = new ListNode(1);
		ln.next = new ListNode(2);
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
		ListNode headPtr = head;
		if (length % 2 == 0) {
			ListNode prev = null;
			int count = 0;
			while (count < length / 2) {
				prev = head;
				head = head.next;
				count++;
			}

			ListNode nextNode = prev.next;
			prev.next = null;
			nextNode = reverseLL(nextNode);
			head = headPtr;
			while (head != null) {
				if (head.val != nextNode.val)
					return false;
				head = head.next;
				nextNode = nextNode.next;
			}
		} else {
			ListNode prev = null;
			int count = 0;
			while (count < length / 2) {
				prev = head;
				head = head.next;
				count++;
			}

			ListNode nextNode = prev.next.next;
			prev.next.next = null;
			prev.next = null;
			nextNode = reverseLL(nextNode);
			head = headPtr;
			while (head != null) {
				if (head.val != nextNode.val)
					return false;
				head = head.next;
				nextNode = nextNode.next;
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
