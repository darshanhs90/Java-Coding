package June2021GoogLeetcode;

public class _0328OddEvenLinkedList {
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
		printNodes(oddEvenList(ln));

		ln = new ListNode(2);
		ln.next = new ListNode(1);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(5);
		ln.next.next.next.next = new ListNode(6);
		ln.next.next.next.next.next = new ListNode(4);
		ln.next.next.next.next.next.next = new ListNode(7);
		printNodes(oddEvenList(ln));
	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode oddEvenList(ListNode head) {
		ListNode oddNode = new ListNode();
		ListNode oddNodePtr = oddNode;
		ListNode evenNode = new ListNode();
		ListNode evenNodePtr = evenNode;
		int count = 0;
		while (head != null) {
			if (count % 2 == 0) {
				oddNode.next = head;
				oddNode = oddNode.next;
			} else {
				evenNode.next = head;
				evenNode = evenNode.next;
			}
			head = head.next;
			count++;
		}

		evenNode.next = null;
		oddNode.next = evenNodePtr.next;
		return oddNodePtr.next;
	}

}
