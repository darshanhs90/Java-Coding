package LeetCodePerformancePractice;

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
		if(head==null)
			return head;
		ListNode fakeLessHead=new ListNode(-1);
		ListNode lessPointer=fakeLessHead;
		ListNode fakeMoreHead=new ListNode(-1);
		ListNode morePointer=fakeMoreHead;

		while(head!=null)
		{
			if(head.val<x)
			{
				fakeLessHead.next=head;
				fakeLessHead=fakeLessHead.next;
			}
			else{
				fakeMoreHead.next=head;
				fakeMoreHead=fakeMoreHead.next;
			}
			head=head.next;
		}
		fakeMoreHead.next=null;
		fakeLessHead.next=morePointer.next;
		if(lessPointer.next==null)
			return morePointer.next;
		else{
			return lessPointer.next;
		}
	}
}
