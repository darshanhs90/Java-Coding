package Dec2020Leetcode;

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
		ListNode slow = new ListNode();
		ListNode fast = new ListNode();
		slow.next = head;
		fast.next = head;
		while (slow != null && fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null)
				fast = fast.next;
		}
		return slow;
	}

}
