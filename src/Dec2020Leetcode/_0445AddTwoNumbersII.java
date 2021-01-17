package Dec2020Leetcode;

public class _0445AddTwoNumbersII {

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
		ListNode ln1 = new ListNode(7);
		ln1.next = new ListNode(2);
		ln1.next.next = new ListNode(4);
		ln1.next.next.next = new ListNode(3);

		ListNode ln2 = new ListNode(5);
		ln2.next = new ListNode(6);
		ln2.next.next = new ListNode(4);

		ln1 = addTwoNumbers(ln1, ln2);
		printNodes(ln1);
	}

	public static void printNodes(ListNode l1) {
		while (l1 != null) {
			System.out.print(l1.val + "->");
			l1 = l1.next;
		}
		System.out.println();
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode op = new ListNode();
		ListNode opPtr = op;
		boolean hasCarry = false;
		l1 = reverseLL(l1);
		l2 = reverseLL(l2);
		
		while (l1 != null || l2 != null) {
			int sum = hasCarry ? 1 : 0;
			hasCarry = false;
			sum += l1 != null ? l1.val : 0;
			l1 = l1 != null ? l1.next : null;
			sum += l2 != null ? l2.val : 0;
			l2 = l2 != null ? l2.next : null;

			if (sum > 9) {
				sum = sum - 10;
				hasCarry = true;
			}
			op.next = new ListNode(sum);
			op = op.next;
		}

		if (hasCarry) {
			op.next = new ListNode(1);
			op = op.next;
		}
		return reverseLL(opPtr.next);
	}

	public static ListNode reverseLL(ListNode ln) {
		if (ln == null || ln.next == null)
			return ln;
		ListNode next = ln.next;
		ListNode reverseNode = reverseLL(ln.next);
		next.next = ln;
		ln.next = null;
		return reverseNode;
	}

}
