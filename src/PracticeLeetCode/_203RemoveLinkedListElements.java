package PracticeLeetCode;

public class _203RemoveLinkedListElements {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(1);
		ln.next.next=new ListNode(6);
		ln.next.next.next=new ListNode(3);
		ln.next.next.next.next=new ListNode(4);
		ln.next.next.next.next.next=new ListNode(5);
		ln.next.next.next.next.next.next=new ListNode(6);
		ln=removeElements(ln, 1);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	public static ListNode removeElements(ListNode head, int val) {
		a
	}
}