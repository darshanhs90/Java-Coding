package Dec2020Leetcode;

public class _0024SwapNodesInPairs {
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
		ListNode ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln = swapPairs(ln);
		printElements(ln);
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln = swapPairs(ln);
		printElements(ln);
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln = swapPairs(ln);
		printElements(ln);
		System.out.println();

		ln = new ListNode(1);
		ln = swapPairs(ln);
		printElements(ln);
		System.out.println();
	}

	
}
