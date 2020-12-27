package Dec2020Leetcode;

public class _0083RemoveDuplicatesFromSortedList {
	public static class ListNode {
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
		ln.next = new ListNode(1);
		ln.next.next = new ListNode(2);
		ln = deleteDuplicates(ln);
		while (ln != null) {
			System.out.print(ln.val + "->");
			ln = ln.next;
		}
		System.out.println();
		ln = new ListNode(1);
		ln.next = new ListNode(1);
		ln.next.next = new ListNode(2);
		ln.next.next.next = new ListNode(3);
		ln.next.next.next.next = new ListNode(3);
		ln = deleteDuplicates(ln);
		while (ln != null) {
			System.out.print(ln.val + "->");
			ln = ln.next;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode headPtr = new ListNode();
		ListNode headPtrNew = headPtr;
		headPtr.next = head;
		headPtr = headPtr.next;
		Integer currVal = head.val;

		while (head != null) {
			while (head != null && head.val == currVal) {
				head = head.next;
			}
			if (head != null) {
				headPtr.next = head;
				headPtr = headPtr.next;
				currVal = head.val;
			}
		}
		headPtr.next = null;
		return headPtrNew.next;
	}

}
