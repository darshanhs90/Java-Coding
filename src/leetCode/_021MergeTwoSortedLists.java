package leetCode;

/*
 * Link : https://leetcode.com/problems/move-zeroes/
 */

public class _021MergeTwoSortedLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode head=new ListNode(0);
		ListNode pointer=new ListNode(0);
		head.next=pointer;
		while(l1!=null || l2!=null)
		{
			if(l1!=null && l2!=null)
			{
				if(l1.val<l2.val)
				{
					pointer.next=new ListNode(l1.val);
					l1=l1.next;
				}
				else{
					pointer.next=new ListNode(l2.val);
					l2=l2.next;
				}
			}
			else if(l1!=null)
			{
				pointer.next=new ListNode(l1.val);
				l1=l1.next;
			}
			else 
			{
				pointer.next=new ListNode(l2.val);
				l2=l2.next;
			}
			pointer=pointer.next;

		}
		return head.next.next;
	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln1=new ListNode(10);
		ln1.next=new ListNode(12);
		ln1.next.next=new ListNode(14);
		ln1.next.next.next=new ListNode(15);
		ln1.next.next.next.next=new ListNode(16);
		ln1.next.next.next.next.next=new ListNode(17);
		ListNode ln2=new ListNode(10);
		ln2.next=new ListNode(12);
		ln2.next.next=new ListNode(14);
		ln2.next.next.next=new ListNode(15);
		ln2.next.next.next.next=new ListNode(16);
		ln2.next.next.next.next.next=new ListNode(17);
		
		ln1=mergeTwoLists(ln1, ln2);
		while(ln1!=null){
			System.out.print(ln1.val+"/");
			ln1=ln1.next;
		}
		
	}
}