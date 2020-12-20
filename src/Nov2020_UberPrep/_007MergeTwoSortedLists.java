package Nov2020_UberPrep;

public class _007MergeTwoSortedLists {

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
		ListNode ln1 = new ListNode(1);
		ln1.next = new ListNode(2);
		ln1.next.next = new ListNode(4);
		ListNode ln2 = new ListNode(1);
		ln2.next = new ListNode(3);
		ln2.next.next = new ListNode(4);
		ln1 = mergeTwoLists(ln1, ln2);
		printNodes(ln1);

		ln2 = new ListNode(0);
		ln1 = mergeTwoLists(null, ln2);
		printNodes(ln1);

		ln1 = mergeTwoLists(null, null);
		printNodes(ln1);

	}

	public static void printNodes(ListNode l1) {
		while (l1 != null) {
			System.out.print(l1.val + "->");
			l1 = l1.next;
		}
		System.out.println();
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode output = new ListNode();
		ListNode outputPtr = output;

		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					output.next = new ListNode(l1.val);
					l1 = l1.next;
				} else {
					output.next = new ListNode(l2.val);
					l2 = l2.next;
				}
			} else if (l1 != null) {
				output.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				output.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			output = output.next;
		}

		return outputPtr.next;
	}

}
