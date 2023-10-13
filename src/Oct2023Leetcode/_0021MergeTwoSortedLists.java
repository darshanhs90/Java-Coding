package Oct2023Leetcode;

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
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

	}

}
