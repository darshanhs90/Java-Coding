package PracticeLeetCode;

public class _021MergeTwoSortedLists {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null||l2==null)
			return l1!=null?l1:l2;
		ListNode headPointer=new ListNode(-1);
		ListNode output=headPointer;
		while(l1!=null && l2!=null)
		{
			if(l1.val<l2.val)
			{
				headPointer.next=new ListNode(l1.val);
				headPointer=headPointer.next;
				l1=l1.next;
			}
			else{
				headPointer.next=new ListNode(l2.val);
				headPointer=headPointer.next;
				l2=l2.next;
			}
		}
		if(l1!=null)
		{
			while(l1!=null)
			{
				headPointer.next=new ListNode(l1.val);
				headPointer=headPointer.next;
				l1=l1.next;
			}
		}else if(l2!=null)
		{
			while(l2!=null)
			{
				headPointer.next=new ListNode(l2.val);
				headPointer=headPointer.next;
				l2=l2.next;
			}
		}
		return output.next;
	}
}

