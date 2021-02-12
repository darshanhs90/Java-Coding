package Jan2021Leetcode;

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

	public static void printElements(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode op = new ListNode();
		ListNode opPtr = op;

		ListNode prev = op;
		while(head!=null && head.next!=null)
		{
			ListNode curr = head;
			ListNode next = head.next;
			ListNode laterNode = head.next.next;
			
			prev.next = next;
			next.next = curr;
			curr.next = laterNode;
			
			prev = curr;
			
			head = head.next;
		}
		return opPtr.next;
	}

}
