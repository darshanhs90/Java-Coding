package LeetcodeTemplate;

public class _2130MaximumTwinSumOfALinkedList {
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
		System.out.println(pairSum(ln));
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		System.out.println(pairSum(ln));
		ln.next.next.next.next = new ListNode(5);
		ln.next.next.next.next.next = new ListNode(6);
		System.out.println(pairSum(ln));
	}

	public static int pairSum(ListNode head) {

	}
}
