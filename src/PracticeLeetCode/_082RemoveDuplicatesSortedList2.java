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
		if(head==null||head.next==null)
			return head;
		ListNode prevNode=new ListNode(-1);
		ListNode pointer=prevNode;
		while(head!=null)
		{
			int currVal=head.val;
			ListNode temp=head;
			head=head.next;
			if(head!=null && head.val==currVal)
				while(head!=null && currVal==head.val)
				{
					head=head.next;
				}
			else{
				prevNode.next=temp;
				prevNode=prevNode.next;
			}
		}
		prevNode.next=null;
		return pointer.next;
	}

}
