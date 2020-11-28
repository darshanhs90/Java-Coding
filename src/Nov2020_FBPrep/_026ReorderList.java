package Nov2020_FBPrep;

public class _026ReorderList {
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
		printNodes(ln);
		reorderList(ln);
		printNodes(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(5);
		printNodes(ln);
		reorderList(ln);
		printNodes(ln);
	}

	public static void printNodes(ListNode ln) {
		while (ln != null) {
			System.out.print(ln.val + "->");
			ln = ln.next;
		}
		System.out.println("");
	}

	public static void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

		ListNode leftPart = head;

		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null)
				fast = fast.next;
		}
		ListNode rightPart = reverseLL(slow.next);
		slow.next = null;
		printNodes(rightPart);
		ListNode output = new ListNode();
		ListNode outputPtr = output;

		while (leftPart != null || rightPart != null) {
			if (leftPart != null) {
				output.next = leftPart;
				output = output.next;
				leftPart = leftPart.next;
			}

			if (rightPart != null) {
				output.next = rightPart;
				output = output.next;
				rightPart = rightPart.next;
			}
		}
		head = outputPtr.next;
	}

	public static ListNode reverseLL(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode next = head.next;
		ListNode newNode = reverseLL(next);
		next.next = head;
		head.next = null;
		return newNode;
	}
}
