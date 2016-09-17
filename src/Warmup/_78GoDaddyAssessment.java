package Warmup;

public class _78GoDaddyAssessment {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {

		ListNode ln=new ListNode(4);
		/*ln.next=new ListNode(2);
		ln.next.next=new ListNode(3);
		ln.next.next.next=new ListNode(4);
		ln.next.next.next.next=new ListNode(5);*/
		ln=removeNodes(ln,3);
		while(ln!=null)
		{
			System.out.println(ln.val);
			ln=ln.next;
		}
	}
	private static ListNode removeNodes(ListNode ln, int x) {
		while(ln!=null && ln.val>x)
		{
			ln=ln.next;
		}
		if(ln==null || ln.next==null)
			return ln;
		ListNode prev=ln;
		ListNode prevPointer=prev;
		ListNode newHead=ln.next;
		while(newHead!=null)
		{
			if(newHead.val>x)
			{
				prev.next=newHead.next;
			}
			else
			{
				prev.next=newHead;
				prev=prev.next;
			}
			newHead=newHead.next;
		}
		return prevPointer;
	}

}

