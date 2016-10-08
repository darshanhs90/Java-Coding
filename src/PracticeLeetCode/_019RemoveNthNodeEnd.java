package PracticeLeetCode;

public class _019RemoveNthNodeEnd {
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
		ln=(removeNthFromEnd(ln, 1));
		while(ln!=null)
		{
			System.out.println(ln.val);
			ln=ln.next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode leadPointer=head;
		ListNode lagPointer=head;
		int count=0;
		while(leadPointer!=null && count<n)
		{
			leadPointer=leadPointer.next;
			count++;
		}
		if(leadPointer==null)
			return head.next;
		ListNode prevNode=null;
		while(leadPointer!=null)
		{
			leadPointer=leadPointer.next;
			prevNode=lagPointer;
			lagPointer=lagPointer.next;
		}
		prevNode.next=lagPointer.next;
		return head;
	}
}
