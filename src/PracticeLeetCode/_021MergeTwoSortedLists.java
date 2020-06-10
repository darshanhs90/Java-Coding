package PracticeLeetCode;

public class _021MergeTwoSortedLists {
	public static void main(String[] args) {

	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode output = new ListNode(-1);
		ListNode outputPointer = output;
		while(l1 != null && l2 != null)
		{
			if(l1.val < l2.val)
			{
				output.next = new ListNode(l1.val);
				l1 = l1.next;
			}
			else {
				output.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			output = output.next;
		}
		
		while(l1 != null)
		{
			output.next = new ListNode(l1.val);
			l1 = l1.next;
			output = output.next;
		}
		
		
		while(l2 != null)
		{
			output.next = new ListNode(l2.val);
			l2 = l2.next;
			output = output.next;
		}
		
		return outputPointer.next;
	}
	
}

