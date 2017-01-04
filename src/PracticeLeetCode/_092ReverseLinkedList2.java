package PracticeLeetCode;

public class _092ReverseLinkedList2 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(3);
		ln.next.next.next=new ListNode(4);
		ln.next.next.next.next=new ListNode(5);
		ln=reverseBetween(ln,1,2);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		return reverseLL(head);
	}
	private static ListNode reverseLL(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode nextNode=head.next;
		ListNode reverse=reverseLL(head.next);
		head.next=null;
		nextNode.next=head;
		return reverse;
	}
	
	
}
