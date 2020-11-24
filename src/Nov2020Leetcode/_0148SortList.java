package Nov2020Leetcode;

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

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode prev = null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;

		ListNode left = sortList(head);
		ListNode right = sortList(slow);
		ListNode dummy = new ListNode();
		ListNode dummyPtr = dummy;
		while (left != null || right != null) {
			if (left != null && right != null) {
				if (left.val < right.val) {
					dummy.next = left;
					left = left.next;
				} else {
					dummy.next = right;
					right = right.next;
				}
			} else if (left != null) {
				dummy.next = left;
				left = left.next;
			} else {
				dummy.next = right;
				right = right.next;
			}
			dummy = dummy.next;
		}

		return dummyPtr.next;
	}

	public static void printNodes(ListNode ln) {
		while (ln != null) {
			System.out.print(ln.val + "->");
			ln = ln.next;
		}
		System.out.println();
	}
}
