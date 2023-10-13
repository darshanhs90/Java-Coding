package Oct2023Leetcode;

public class _0148SortList {
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
		ListNode ln = new ListNode(4);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(1);
		ln.next.next.next = new ListNode(3);
		printNodes(sortList(ln));

		ln = new ListNode(-1);
		ln.next = new ListNode(5);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(0);
		printNodes(sortList(ln));

	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "/");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode sortList(ListNode head) {
		
	}

}
