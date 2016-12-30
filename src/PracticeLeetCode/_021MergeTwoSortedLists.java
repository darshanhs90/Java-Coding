package PracticeLeetCode;

public class _021MergeTwoSortedLists {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null||l2==null)
			return l1==null?l2:l1;
		ListNode output=new ListNode(-1);
		ListNode outputPointer=output;
		while(l1!=null && l2!=null)
		{
			if(l1.val<l2.val)
			{
				output.next=new ListNode(l1.val);
				l1=l1.next;
			}
			else{
				output.next=new ListNode(l2.val);
				l2=l2.next;
			}
			output=output.next;
		}
		if(l1!=null)
			while(l1!=null)
			{
				output.next=new ListNode(l1.val);
				l1=l1.next;
				output=output.next;
			}
		if(l2!=null)
			while(l2!=null)
			{
				output.next=new ListNode(l2.val);
				l2=l2.next;
				output=output.next;
			}
		return outputPointer.next;
	}
}

