package LeetCodePractice;

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
		while(ln!=null){System.out.print(ln.val+"/");ln=ln.next;}System.out.println();
	}									


	public static ListNode partition(ListNode head, int x) {
		ListNode output=new ListNode(-1);
		ListNode outputPointer=output;
		ListNode headPointer=head;
		while(head!=null)
		{
			if(head.val<x)
			{
				output.next=new ListNode(head.val);
				output=output.next;
			}
			head=head.next;
		}
		while(headPointer!=null)
		{
			if(headPointer.val>=x)
			{
				output.next=new ListNode(headPointer.val);
				output=output.next;
			}
			headPointer=headPointer.next;
		}
		return outputPointer.next;
	}

}

