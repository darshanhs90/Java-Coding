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
		ListNode headPointer=head;
		while(head!=null && n!=0){
			head=head.next;
			n--;
		}
		if(head==null && headPointer!=null)
			return headPointer.next;
		ListNode secondHead=headPointer;
		while(head!=null && head.next!=null){
			head=head.next;
			secondHead=secondHead.next;
		}
		if(secondHead!=null)
		{
			secondHead.next=secondHead.next!=null?secondHead.next.next:null;
		}
		return headPointer;	
	}
}
