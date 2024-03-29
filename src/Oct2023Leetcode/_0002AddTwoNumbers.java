package Oct2023Leetcode;

public class _0002AddTwoNumbers {
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
		ListNode ln1 = new ListNode(2);
		ln1.next = new ListNode(4);
		ln1.next.next = new ListNode(3);
		ListNode ln2 = new ListNode(5);
		ln2.next = new ListNode(6);
		ln2.next.next = new ListNode(4);
		ln1 = addTwoNumbers(ln1, ln2);
		printElements(ln1);

		ln1 = new ListNode(0);
		ln2 = new ListNode(0);
		ln1 = addTwoNumbers(ln1, ln2);
		printElements(ln1);

		ln1 = new ListNode(9);
		ln1.next = new ListNode(9);
		ln1.next.next = new ListNode(9);
		ln1.next.next.next = new ListNode(9);
		ln1.next.next.next.next = new ListNode(9);
		ln1.next.next.next.next.next = new ListNode(9);
		ln1.next.next.next.next.next.next = new ListNode(9);
		ln2 = new ListNode(9);
		ln2.next = new ListNode(9);
		ln2.next.next = new ListNode(9);
		ln2.next.next.next = new ListNode(9);
		ln1 = addTwoNumbers(ln1, ln2);
		printElements(ln1);
	}

	public static void printElements(ListNode l1) {
		while (l1 != null) {
			System.out.print(l1.val + "->");
			l1 = l1.next;
		}
		System.out.println();
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		ListNode ln = new ListNode(-1);
		ListNode ptr = ln;
		int carry = 0, val1 = 0, val2 = 0;
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				val1 = l1.val;
				l1 = l1.next;
			} else {
				val1 = 0;
			}
			if (l2 != null) {
				val2 = l2.val;
				l2 = l2.next;
			} else {
				val2 = 0;
			}

			int sum = val1 + val2 + carry;
			if (sum > 9) {
				carry = 1;
				sum = sum - 10;
			} else {
				carry = 0;
			}
			ListNode node = new ListNode(sum);
			ln.next = node;
			ln = ln.next;
		}
		if (carry != 0) {
			ListNode node = new ListNode(carry);
			ln.next = node;
			ln = ln.next;
		}
		return ptr.next;
	}

}
