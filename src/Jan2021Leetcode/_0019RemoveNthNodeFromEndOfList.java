package Jan2021Leetcode;

public class _0019RemoveNthNodeFromEndOfList {
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
		ln = removeNthFromEnd(ln, 2);
		printElements(ln);
		System.out.println();

		ln = new ListNode(1);
		ln = removeNthFromEnd(ln, 1);
		printElements(ln);
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln = removeNthFromEnd(ln, 1);
		printElements(ln);
		System.out.println();
	}

	public static void printElements(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {

	}

}
