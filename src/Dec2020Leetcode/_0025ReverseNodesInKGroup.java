package Dec2020Leetcode;

public class _0025ReverseNodesInKGroup {
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
		ln = reverseKGroup(ln, 3);
		printNodes(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(5);
		ln = reverseKGroup(ln, 2);
		printNodes(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(5);
		ln = reverseKGroup(ln, 1);
		printNodes(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(5);
		ln = reverseKGroup(ln, 4);
		printNodes(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(5);
		ln = reverseKGroup(ln, 5);
		printNodes(ln);
		
		
		ln = new ListNode(1);
		ln = reverseKGroup(ln, 1);
		printNodes(ln);

	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	// Iterative
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k == 1)
			return head;
		ListNode prev = new ListNode();
		ListNode prevPtr = prev;
		prev.next = head;
		boolean firstPass = true;
		while (prev.next != null) {
			int count = 0;
			ListNode prevPtrNew = prev;
			while (count < k && prev.next != null) {
				prev = prev.next;
				count++;
			}

			if (count == k) {
				if (firstPass) {
					ListNode nextBlockNode = prev.next;
					// cut connection to next block;
					prev.next = null;

					ListNode startNode = prevPtr.next;
					// cut connection to startNode
					prevPtr.next = null;

					ListNode newHead = reverseLL(startNode);
					prevPtr.next = newHead;
					startNode.next = nextBlockNode;

					prev = startNode;
					firstPass = false;
				} else {
					ListNode nextBlockNode = prev.next;
					// cut connection to next block;
					prev.next = null;

					ListNode startNode = prevPtrNew.next;
					// cut connection to startNode
					prevPtrNew.next = null;

					ListNode newHead = reverseLL(startNode);
					prevPtrNew.next = newHead;
					startNode.next = nextBlockNode;
					prev = startNode;
				}
			} else {
				// reverse is complete
				return prevPtr.next;
			}
		}
		return prevPtr.next;
	}

	public static ListNode reverseLL(ListNode ln) {
		if (ln == null || ln.next == null)
			return ln;
		ListNode nextNode = ln.next;
		ListNode reverseNode = reverseLL(ln.next);
		nextNode.next = ln;
		ln.next = null;
		return reverseNode;
	}
}
