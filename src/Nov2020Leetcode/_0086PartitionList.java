package Nov2020Leetcode;

public class _0086PartitionList {
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
		ln.next = new ListNode(4);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(2);
		ln.next.next.next.next = new ListNode(5);
		ln.next.next.next.next.next = new ListNode(2);
		printNodes(partition(ln, 3));
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(4);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(2);
		ln.next.next.next.next = new ListNode(5);
		ln.next.next.next.next.next = new ListNode(2);
		printNodes(partition(ln, 1));
		System.out.println();
		
		ln = new ListNode(1);
		ln.next = new ListNode(4);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(2);
		ln.next.next.next.next = new ListNode(5);
		ln.next.next.next.next.next = new ListNode(2);
		printNodes(partition(ln, 4));
		System.out.println();
				
		ln = new ListNode(1);
		ln.next = new ListNode(4);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(2);
		ln.next.next.next.next = new ListNode(5);
		ln.next.next.next.next.next = new ListNode(2);
		printNodes(partition(ln, 5));
		System.out.println();
		
		ln = new ListNode(1);
		ln.next = new ListNode(4);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(2);
		ln.next.next.next.next = new ListNode(5);
		ln.next.next.next.next.next = new ListNode(2);
		printNodes(partition(ln, 2));
		System.out.println();
		
		ln = new ListNode(1);
		printNodes(partition(ln, 0));
		System.out.println();
	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

	public static ListNode partition(ListNode head, int x) {
		ListNode leftPart = new ListNode(-1);
		ListNode leftOut = leftPart;
		ListNode rightPart = new ListNode(-1);
		ListNode rightOut = rightPart;

		while (head != null) {
			if (head.val < x) {
				leftPart.next = head;
				leftPart = leftPart.next;
			} else {
				rightPart.next = head;
				rightPart = rightPart.next;
			}
			head = head.next;
		}
		rightPart.next = null;
		if (leftOut.next != null) {
			leftPart.next = rightOut.next;
			return leftOut.next;
		}
		return rightOut.next;
	}
}
