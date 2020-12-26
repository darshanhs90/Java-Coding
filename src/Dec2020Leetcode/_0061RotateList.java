package Dec2020Leetcode;

public class _0061RotateList {
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
		ln = rotateRight(ln, 2);
		printNodes(ln);
		System.out.println();

		ln = new ListNode(0);
		ln.next = new ListNode(1);
		ln.next.next = new ListNode(2);
		ln = rotateRight(ln, 4);
		printNodes(ln);
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln = rotateRight(ln, 1);
		printNodes(ln);
		System.out.println();
	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;
		int length = getLength(head);
		k = length - (k % length);

		if (k == length)
			return head;

		ListNode headPtr1 = head;
		ListNode headPtr2 = head;
		int count = 1;
		while (count < k) {
			headPtr1 = headPtr1.next;
			count++;
		}
		ListNode nextNode = headPtr1.next;
		ListNode nextNodePtr = nextNode;
		headPtr1.next = null;

		if (nextNode != null) {
			while (nextNode != null && nextNode.next != null) {
				nextNode = nextNode.next;
			}
			nextNode.next = headPtr2;
		}
		return nextNodePtr;
	}

	public static int getLength(ListNode head) {
		if (head == null)
			return 0;
		return 1 + getLength(head.next);
	}

}
