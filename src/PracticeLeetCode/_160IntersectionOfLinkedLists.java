package PracticeLeetCode;

public class _160IntersectionOfLinkedLists {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(3);
		ListNode ln1=new ListNode(2);
		ln1.next=ln;
		ln=getIntersectionNode(ln, ln1);
		System.out.println(ln.val);

	}
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
	}
}
