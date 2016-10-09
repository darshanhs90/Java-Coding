package PracticeLeetCode;

public class _143ReorderList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(3);
		ln.next.next.next=new ListNode(4);
		reorderList(ln);
	}
	public static void reorderList(ListNode head) {
		ListNode pointer=head;
		if(head==null||head.next==null)
			return ;
		ListNode fastPointer=head.next.next;
		ListNode slowPointer=head;
		while(fastPointer!=null)
		{
			slowPointer=slowPointer.next;
			fastPointer=fastPointer.next;
			if(fastPointer!=null)
				fastPointer=fastPointer.next;
		}
		ListNode nextNode=slowPointer.next;
		slowPointer.next=null;
		nextNode=reverseLL(nextNode);
		head=pointer;
		while(head!=null && nextNode!=null)
		{
			ListNode headNodeNext=head.next;
			ListNode nextNodeNext=nextNode.next;
			head.next=nextNode;
			nextNode.next=headNodeNext;
			head=headNodeNext;
			nextNode=nextNodeNext;
		}
		head=pointer;
	}
	private static ListNode reverseLL(ListNode ln) {
		if(ln==null||ln.next==null)
			return ln;
		ListNode nextNode=ln.next;
		ln.next=null;
		ListNode reverse=reverseLL(nextNode);
		nextNode.next=ln;
		return reverse;
	}
}