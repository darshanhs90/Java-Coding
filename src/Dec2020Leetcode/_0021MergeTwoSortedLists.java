package Dec2020Leetcode;

public class _0021MergeTwoSortedLists {
	public static class ListNode {
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
		ListNode ln1 = new ListNode(1);
		ln1.next = new ListNode(2);
		ln1.next.next = new ListNode(4);
		ListNode ln2 = new ListNode(1);
		ln2.next = new ListNode(3);
		ln2.next.next = new ListNode(4);
		ln1 = mergeTwoLists(ln1, ln2);
		while (ln1 != null) {
			System.out.print(ln1.val + "->");
			ln1 = ln1.next;
		}
		System.out.println();

		ln1 = null;
		ln2 = null;
		ln1 = mergeTwoLists(ln1, ln2);
		while (ln1 != null) {
			System.out.print(ln1.val + "->");
			ln1 = ln1.next;
		}
		System.out.println();

		ln1 = null;
		ln2 = new ListNode(1);
		ln1 = mergeTwoLists(ln1, ln2);
		while (ln1 != null) {
			System.out.print(ln1.val + "->");
			ln1 = ln1.next;
		}
		System.out.println("************");

		ln1 = new ListNode(1);
		ln1.next = new ListNode(2);
		ln1.next.next = new ListNode(4);
		ln2 = new ListNode(1);
		ln2.next = new ListNode(3);
		ln2.next.next = new ListNode(4);
		ln1 = mergeTwoLists2(ln1, ln2);
		while (ln1 != null) {
			System.out.print(ln1.val + "->");
			ln1 = ln1.next;
		}
		System.out.println();

		ln1 = null;
		ln2 = null;
		ln1 = mergeTwoLists2(ln1, ln2);
		while (ln1 != null) {
			System.out.print(ln1.val + "->");
			ln1 = ln1.next;
		}
		System.out.println();

		ln1 = null;
		ln2 = new ListNode(1);
		ln1 = mergeTwoLists2(ln1, ln2);
		while (ln1 != null) {
			System.out.print(ln1.val + "->");
			ln1 = ln1.next;
		}
		System.out.println();

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode op = new ListNode();
		ListNode opPtr = op;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					op.next = new ListNode(l1.val);
					l1 = l1.next;
				} else {
					op.next = new ListNode(l2.val);
					l2 = l2.next;
				}
			} else if (l1 != null) {
				op.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				op.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			op = op.next;
		}
		return opPtr.next;

	}

	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode op = new ListNode();
		ListNode opPtr = op;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					op.next = l1;
					l1 = l1.next;
				} else {
					op.next = l2;
					l2 = l2.next;
				}
			} else if (l1 != null) {
				op.next = l1;
				break;
			} else {
				op.next = l2;
				break;
			}
			op = op.next;
		}
		return opPtr.next;
	}

}
