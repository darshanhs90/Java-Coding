package PracticeLeetCode;

public class _086PartitionList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(4);
		ln.next.next=new ListNode(3);
		ln.next.next.next=new ListNode(2);
		ln.next.next.next.next=new ListNode(5);
		ln.next.next.next.next.next=new ListNode(2);
		ln=partition(ln,3);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	public static ListNode partition(ListNode head, int x) {
		if(head==null||head.next==null)
			return head;
		ListNode lesserNodePointer=new ListNode(-1);
		ListNode lesser=lesserNodePointer;
		ListNode prevPtr=new ListNode(-1);		
		ListNode headPointer=prevPtr;


		while(head!=null)
		{
			if(head.val<x)
			{
				lesserNodePointer.next=new ListNode(head.val);
				lesserNodePointer=lesserNodePointer.next;
			}
			else{
				prevPtr.next=head;
				prevPtr=prevPtr.next;
			}
			head=head.next;
		}
		prevPtr.next=null;
		lesserNodePointer.next=headPointer.next;
		return lesser.next;
	}
}
