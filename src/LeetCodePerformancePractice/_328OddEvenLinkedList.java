package LeetCodePerformancePractice;

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
		//ln.next.next.next.next.next.next.next=new ListNode(8);
		ln=oddEvenList(ln);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	public static ListNode oddEvenList(ListNode head) {
		if(head==null||head.next==null||head.next.next==null)
			return head;
		ListNode oddNode=head;
		ListNode evenNode=new ListNode(-1);
		ListNode evenNodepointer=evenNode;
		while(oddNode!=null && evenNode!=null)
		{	
			if(oddNode.next==null)
				break;
			evenNode.next=oddNode.next;
			evenNode=evenNode.next;
			if(oddNode.next.next==null)
				break;
			oddNode.next=oddNode.next.next;
			oddNode=oddNode.next;
		}
		if(evenNode!=null)
			evenNode.next=null;
		oddNode.next=evenNodepointer.next;
		return head;
	}
}
