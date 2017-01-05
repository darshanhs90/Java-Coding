package PracticeLeetCode;

public class _143ReorderList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(3);
		//ln.next.next.next=new ListNode(4);
		//ln.next.next.next.next=new ListNode(5);
		reorderList(ln);
	}
	public static void reorderList(ListNode head) {
		if(head==null||head.next==null)
			return;
		int length=getLength(head);
		ListNode headPointer=head;
		ListNode reverse;
		if(length%2==0)
		{
			int count=0;
			while(count<(length/2))
			{
				count++;
				head=head.next;
			}
			ListNode temp=head.next;
			head.next=null;
			reverse=reverseLL(temp);
		}
		else{
			int count=0;
			while(count<(length/2))
			{
				count++;
				head=head.next;
			}
			ListNode temp=head.next;
			head.next=null;
			reverse=reverseLL(temp);
		}
		ListNode output=new ListNode(-1);
		ListNode outputPointer=output;
		
		while(headPointer!=null && reverse!=null)
		{
			output.next=headPointer;
			headPointer=headPointer.next;
			output=output.next;
			output.next=reverse;
			reverse=reverse.next;
			output=output.next;
		}
		if(headPointer!=null)
		{
			output.next=headPointer;
			output=output.next;
		}
		head=outputPointer.next;
		while(head!=null)
		{
			System.out.println(head.val);head=head.next;
		}
	}
	private static ListNode reverseLL(ListNode ln) {
		if(ln==null||ln.next==null)
			return ln;
		ListNode next=ln.next;
		ListNode reverse=reverseLL(ln.next);
		ln.next=null;
		next.next=ln;
		return reverse;
	}
	private static int getLength(ListNode head) {
		return head==null?0:1+getLength(head.next);
	}
}