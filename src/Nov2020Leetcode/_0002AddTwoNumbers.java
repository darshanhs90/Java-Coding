package Nov2020Leetcode;

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
			System.out.println(l1.val);
			l1 = l1.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		boolean hasCarry = false;
		ListNode op = new ListNode(-1);
		ListNode opPointer = op;
		int sum = 0;
		while (l1 != null || l2 != null) {
			sum = hasCarry ? 1 : 0;
			hasCarry = false;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			if (sum > 9) {
				sum = sum - 10;
				hasCarry = true;
			}
			opPointer.next = new ListNode(sum);
			opPointer = opPointer.next;
		}
		if (hasCarry) {
			opPointer.next = new ListNode(1);
			opPointer = opPointer.next;
		}
		return op.next;
	}
}
