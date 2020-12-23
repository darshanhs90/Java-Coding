package Dec2020Leetcode;

public class _0024SwapNodesInPairs {
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
		ln = swapPairs(ln);
		printElements(ln);
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln = swapPairs(ln);
		printElements(ln);
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln = swapPairs(ln);
		printElements(ln);
		System.out.println();

		ln = new ListNode(1);
		ln = swapPairs(ln);
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

	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode op = new ListNode();
		ListNode opPtr = op;

		ListNode prev = op;
		prev.next = head;
		while (prev != null && prev.next != null && prev.next.next != null) {

			ListNode nextNode = prev.next;
			ListNode nextNode1 = prev.next.next;
			ListNode nextNode2 = prev.next.next.next;

			prev.next = nextNode1;
			nextNode1.next = nextNode;
			nextNode.next = nextNode2;
			prev = prev.next.next;
		}
		return opPtr.next;
	}

}
