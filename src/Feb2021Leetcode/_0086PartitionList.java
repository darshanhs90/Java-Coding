package Feb2021Leetcode;

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
		ListNode lessThan = new ListNode();
		ListNode lessThanPtr = lessThan;

		ListNode moreThan = new ListNode();
		ListNode moreThanPtr = moreThan;

		while (head != null) {
			if (head.val < x) {
				lessThan.next = head;
				lessThan = lessThan.next;
			} else {
				moreThan.next = head;
				moreThan = moreThan.next;
			}
			head = head.next;
		}

		moreThan.next = null;

		lessThan.next = moreThanPtr.next;
		return lessThanPtr.next;
	}

}
