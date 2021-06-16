package June2021AppleLeetcode;

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
		
	}

}
