package Dec2020Leetcode;

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
		ListNode headPtr = head;
		ListNode slowPtr = new ListNode();
		slowPtr.next = head;
		ListNode fastPtr = new ListNode();
		fastPtr.next = head;
		ListNode prev = null;
		while (fastPtr != null) {
			prev = slowPtr;
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
			if (fastPtr != null)
				fastPtr = fastPtr.next;
		}
		ListNode nextNode = prev.next;
		prev.next = null;
		ListNode reverse = reverseLL(nextNode);

		while (headPtr != null && reverse != null) {
			if (headPtr.val != reverse.val)
				return false;
			headPtr = headPtr.next;
			reverse = reverse.next;
		}
		return true;
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
