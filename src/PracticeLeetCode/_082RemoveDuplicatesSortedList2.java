package PracticeLeetCode;

public class _082RemoveDuplicatesSortedList2 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(2);
/*		ln.next.next.next=new ListNode(3);
		ln.next.next.next.next=new ListNode(3);
		ln.next.next.next.next.next=new ListNode(4);
		ln.next.next.next.next.next.next=new ListNode(5);*/
		ln=deleteDuplicates(ln);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	public static ListNode deleteDuplicates(ListNode head) {
		
	}

}
