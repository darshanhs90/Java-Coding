package Dec2020Leetcode;

public class _0148SortList {
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
		ListNode ln = new ListNode(4);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(1);
		ln.next.next.next = new ListNode(3);
		printNodes(sortList(ln));

		ln = new ListNode(-1);
		ln.next = new ListNode(5);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(0);
		printNodes(sortList(ln));

	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "/");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode mid = getMid(head);
		ListNode left = sortList(head);
		ListNode right = sortList(mid);
		return merge(left, right);
	}

	public static ListNode merge(ListNode list1, ListNode list2) {
		ListNode dummyHead = new ListNode();
		ListNode tail = dummyHead;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				tail.next = list1;
				list1 = list1.next;
				tail = tail.next;
			} else {
				tail.next = list2;
				list2 = list2.next;
				tail = tail.next;
			}
		}
		tail.next = (list1 != null) ? list1 : list2;
		return dummyHead.next;
	}

	public static ListNode getMid(ListNode head) {
		ListNode midPrev = null;
		while (head != null && head.next != null) {
			midPrev = (midPrev == null) ? head : midPrev.next;
			head = head.next.next;
		}
		ListNode mid = midPrev.next;
		midPrev.next = null;
		return mid;
	}

}
