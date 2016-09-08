package LeetCodePerformancePractice;

public class _083RemoveDuplicatesSortedList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(2);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(3);
		ln.next.next.next=new ListNode(3);
		ln.next.next.next.next=new ListNode(4);
		ln.next.next.next.next.next=new ListNode(4);
		ln.next.next.next.next.next.next=new ListNode(5);
		ln=deleteDuplicates(ln);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}

	}
	private static ListNode deleteDuplicates(ListNode ln) {
		ListNode output=new ListNode(0);
		output.next=null;
		ListNode pointer=output;
		while(ln!=null)
		{
			if(ln.next!=null && ln.val==ln.next.val)
			{
				while(ln!=null && ln.next!=null && ln.val==ln.next.val)
				{
					ln=ln.next;
				}
			}
			output.next=ln;
			output=output.next;
			ln=ln.next;
		}
		return pointer.next;
	}

}
