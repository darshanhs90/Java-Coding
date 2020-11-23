package Nov2020Leetcode;

public class _0876MiddleOfTheLinkedList {
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
		System.out.println(middleNode(ln).val);
		
		ln.next.next.next.next.next = new ListNode(6);
		System.out.println(middleNode(ln).val);
	}

	public static ListNode middleNode(ListNode head) {
		int length = getLength(head);
		int index = 0;
		while (index < length / 2) {
			head = head.next;
			index++;
		}
		return head;
	}

	public static int getLength(ListNode head) {
		return head != null ? 1 + getLength(head.next) : 0;
	}
}
