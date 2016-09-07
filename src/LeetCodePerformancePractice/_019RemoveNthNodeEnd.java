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
		ln.next.next=new ListNode(3);
		ln.next.next.next=new ListNode(4);
		ln.next.next.next.next=new ListNode(5);
		ln=(removeNthFromEnd(ln, 5));
		while(ln!=null)
		{
			System.out.println(ln.val);
			ln=ln.next;
		}
	}
	private static ListNode removeNthFromEnd(ListNode ln, int i) {
		ListNode prev=new ListNode(0);
		ListNode curr=ln;
		ListNode fastPointer=ln;
		while(i>0)
		{
			fastPointer=fastPointer.next;
			i--;
		}
		if(fastPointer==null)
			return ln.next;
		while(fastPointer!=null)
		{
			prev=curr;
			curr=curr.next;
			fastPointer=fastPointer.next;
		}
		prev.next=curr!=null?curr.next:null;
		return ln;
	}

}
