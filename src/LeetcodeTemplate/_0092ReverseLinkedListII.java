package LeetcodeTemplate;

public class _0092ReverseLinkedListII {

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
		ln.next.next.next.next = new ListNode(5);
		ln = reverseBetween(ln, 2, 4);
		printNodes(ln);
		System.out.println();

		ln = new ListNode(3);
		ln.next = new ListNode(5);
		ln = reverseBetween(ln, 1, 2);
		printNodes(ln);
	}

	
}
