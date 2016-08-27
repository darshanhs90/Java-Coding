package LeetCodePerformancePractice;

public class _024SwapNodesInPairs {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(3);
		/*ln.next.next.next=new ListNode(4);*/
		ln=swapPairs(ln);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	public static ListNode swapPairs(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode headPointer=head.next;
		ListNode curr=head,prev=null;
		while(curr!=null && curr.next!=null)
		{
			ListNode currNextNext=curr.next.next;
			ListNode currNext=curr.next;
			if(prev==null)
			{
				currNext.next=curr;
				curr.next=currNextNext;
			}
			else{
				currNext.next=curr;
				curr.next=currNextNext;
				prev.next=currNext;
			}
			prev=curr;
			curr=curr.next;
		}
		return headPointer;
	}
	

	
	
}

