package Leetcode2020Nov;

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
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode pointer = new ListNode(-1);
		pointer.next = head;

		ListNode slowPointer = pointer, fastPointer = pointer;
		int count = 0;
		while (count <= n) {
			fastPointer = fastPointer.next;
			count++;
		}
		while (fastPointer != null) {
			fastPointer = fastPointer.next;
			slowPointer = slowPointer.next;
		}

		slowPointer.next = slowPointer.next.next;
		return pointer.next;
	}

}
