package PracticeLeetCode;

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
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode pointer=head;
		if(head==null||head.next==null)
			return head;
		ListNode prevNode=null;
		while(head!=null)
		{
			if(prevNode!=null && head.val==prevNode.val)
			{
				//do nothing
			}
			else{
				if(prevNode==null)
					prevNode=head;
				else{
					prevNode.next=head;
					prevNode=prevNode.next;
				}
			}
			head=head.next;
		}
		prevNode.next=null;
		return pointer;
	}
}
