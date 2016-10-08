package PracticeLeetCode;

public class _021MergeTwoSortedLists {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head=new ListNode(-1);
		ListNode pointer=head;
		while(l1!=null && l2!=null)
		{
			if(l1.val>l2.val)
			{
				head.next=new ListNode(l2.val);
				l2=l2.next;
			}
			else{
				head.next=new ListNode(l1.val);
				l1=l1.next;
			}
			head=head.next;
		}
		while(l1!=null)
		{
			head.next=new ListNode(l1.val);
			l1=l1.next;
			head=head.next;
		}
		while(l2!=null)
		{
			head.next=new ListNode(l2.val);
			l2=l2.next;
			head=head.next;
		}
		return pointer.next;
	}
}

