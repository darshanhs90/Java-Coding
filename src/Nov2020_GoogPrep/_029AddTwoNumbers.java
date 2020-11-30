package Nov2020_GoogPrep;

public class _029AddTwoNumbers {
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
		printNodes(ln1);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode output = new ListNode();
		ListNode outputPtr = output;
		boolean hasCarry = false;
		while (l1 != null || l2 != null) {
			int sum = hasCarry ? 1 : 0;
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
			output.next = new ListNode(sum);
			output = output.next;
		}
		if (hasCarry) {
			output.next = new ListNode(1);
			output = output.next;
		}
		return outputPtr.next;
	}

	public static void printNodes(ListNode ln) {
		while (ln != null) {
			System.out.print(ln.val + "->");
			ln = ln.next;
		}
		System.out.println();
	}
}
