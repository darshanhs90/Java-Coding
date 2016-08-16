package LeetCodePerformancePractice;

public class _019RemoveNthNodeEnd {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		/*ln.next.next=new ListNode(3);
		ln.next.next.next=new ListNode(4);
		ln.next.next.next.next=new ListNode(5);*/
		ln=(removeNthFromEnd(ln, 1));
		while(ln!=null)
		{
			System.out.println(ln.val);
			ln=ln.next;
		}
	}
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode pointer=head;
		while(head!=null && n!=0)
		{
			head=head.next;
			n--;
		}
		if(head==null)
			return pointer.next;
		ListNode prev=null,curr=pointer;
		while(head!=null)
		{
			prev=curr;
			curr=curr.next;
			head=head.next;
		}
		System.out.println(prev);
		System.out.println(curr);
		
		if(prev!=null)
			prev.next=curr!=null?curr.next:null;
		return pointer;
	}
}
