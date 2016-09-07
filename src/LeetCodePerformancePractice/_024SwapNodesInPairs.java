package LeetCodePerformancePractice;

public class _024SwapNodesInPairs {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		/*ln.next=new ListNode(2);
		ln.next.next=new ListNode(3);
		ln.next.next.next=new ListNode(4);*/
		ln=swapPairs(ln);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	public static ListNode swapPairs(ListNode head) {
		ListNode pointer=new ListNode(0);
		pointer.next=head;
		ListNode output=pointer;
		ListNode curr=null;
		while(pointer!=null)
		{
			ListNode prev=pointer.next;
			if(prev!=null && prev.next!=null){
				curr=prev.next;
				prev.next=curr!=null?curr.next:curr;
				if(curr!=null)
					curr.next=prev;
				pointer.next=curr;
			}
			pointer=prev;
		}
		return output.next;
	}


}

