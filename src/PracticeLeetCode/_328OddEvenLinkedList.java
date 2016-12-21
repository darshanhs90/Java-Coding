package PracticeLeetCode;

public class _328OddEvenLinkedList {
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
		ln.next.next.next.next=new ListNode(5);
		ln.next.next.next.next.next=new ListNode(6);
		ln.next.next.next.next.next.next=new ListNode(7);
		ln.next.next.next.next.next.next.next=new ListNode(8);
		ln=oddEvenList(ln);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	private static ListNode oddEvenList(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode headPointer=head;
		ListNode evenHead=new ListNode(-1);
		ListNode evenNodePtr=evenHead;
		while(head!=null && head.next!=null)
		{
			ListNode ln=head.next;
			head.next=head.next.next;
			evenHead.next=ln;
			evenHead=evenHead.next;
			if(head.next!=null)
				head=head.next;
		}
		evenHead.next=null;
		head.next=evenNodePtr.next;
		return headPointer;
	}

}