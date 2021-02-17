package Jan2021Leetcode;

public class _0082RemoveDuplicatesFromSortedListII {
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
		ln.next.next = new ListNode(2);
		ln.next.next.next = new ListNode(3);
		ln.next.next.next.next = new ListNode(3);
		ln.next.next.next.next.next = new ListNode(4);
		ln.next.next.next.next.next.next = new ListNode(4);
		ln.next.next.next.next.next.next.next = new ListNode(5);
		printNodes(deleteDuplicates(ln));
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(1);
		ln.next.next = new ListNode(1);
		ln.next.next.next = new ListNode(2);
		ln.next.next.next.next = new ListNode(3);
		ln.next.next.next.next.next = new ListNode(4);
		ln.next.next.next.next.next.next = new ListNode(5);
		printNodes(deleteDuplicates(ln));
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(1);
		ln.next.next = new ListNode(1);
		printNodes(deleteDuplicates(ln));
		System.out.println();

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(2);
		printNodes(deleteDuplicates(ln));
		System.out.println();

	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode op = new ListNode();
		ListNode opPtr = op;
		
		while(head!=null)
		{
			if(head.next!=null && head.val == head.next.val)
			{
				int val = head.val;
				while(head.next!=null && head.next.val == val)
				{
					head = head.next;
				}
				head = head.next;
			}
			else {
				op.next = head;
				op = op.next;
				head = head.next;
			}
		}
		op.next = null;
		return opPtr.next;
	}

}
