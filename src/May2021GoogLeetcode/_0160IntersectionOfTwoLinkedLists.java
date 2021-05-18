package May2021GoogLeetcode;

public class _0160IntersectionOfTwoLinkedLists {
	static public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		ListNode ln1 = new ListNode(4);
		ln1.next = new ListNode(1);
		ln1.next.next = new ListNode(8);
		ln1.next.next.next = new ListNode(4);
		ln1.next.next.next.next = new ListNode(5);
		ListNode ln2 = new ListNode(5);
		ln2.next = new ListNode(6);
		ln2.next.next = new ListNode(2);
		ln2.next.next.next = ln1.next.next;
		System.out.println(getIntersectionNode(ln1, ln2).val);

		ln1 = new ListNode(1);
		ln1.next = new ListNode(9);
		ln1.next.next = new ListNode(1);
		ln1.next.next.next = new ListNode(2);
		ln1.next.next.next.next = new ListNode(54);
		ln2 = new ListNode(3);
		ln2.next = ln1.next.next.next;
		System.out.println(getIntersectionNode(ln1, ln2).val);

		ln1 = new ListNode(2);
		ln1.next = new ListNode(6);
		ln1.next.next = new ListNode(4);
		ln2 = new ListNode(1);
		ln2.next = new ListNode(5);
		System.out.println(getIntersectionNode(ln1, ln2));
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

	}
}
