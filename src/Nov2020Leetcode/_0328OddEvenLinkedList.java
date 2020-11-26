package Nov2020Leetcode;

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
		System.out.println("");
	}

	public static ListNode oddEvenList(ListNode head) {
		ListNode oddList = new ListNode();
		ListNode oddListPtr = oddList;
		ListNode evenList = new ListNode();
		ListNode evenListPtr = evenList;
		int count = 1;
		while (head != null) {
			if (count % 2 == 0) {
				evenList.next = head;
				evenList = evenList.next;
			} else {
				oddList.next = head;
				oddList = oddList.next;
			}
			head = head.next;
			count++;
		}
		oddList.next = evenListPtr.next;
		evenList.next = null;
		return oddListPtr.next;
	}

}
