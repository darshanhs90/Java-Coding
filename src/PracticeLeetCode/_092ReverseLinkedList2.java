package PracticeLeetCode;

public class _092ReverseLinkedList2 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
/*		ln.next.next=new ListNode(3);
		ln.next.next.next=new ListNode(4);
		ln.next.next.next.next=new ListNode(5);*/
		ln=reverseBetween(ln,1,2);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode prevMHead=head;
		int count=1;
		while(count<m)
		{
			head=head.next;
			count++;
		}
		ListNode newNode=head.next;
		ListNode newNodePointer=head.next;
		head.next=null;
		while(count<n)
		{
			newNode=newNode.next;
			count++;
		}
		ListNode nHead=newNode!=null?newNode.next:null;
		if(newNode!=null)
			newNode.next=null;
		ListNode reverseList=reverseLL(newNodePointer);
		ListNode pointer=prevMHead;
		while(pointer!=null && pointer.next!=null)
		{
			pointer=pointer.next;
		}
		pointer.next=reverseList;
		while(pointer!=null && pointer.next!=null)
		{
			pointer=pointer.next;
		}
		pointer.next=nHead;
		return prevMHead;
	}



	private static ListNode reverseLL(ListNode ln) {
		if(ln==null||ln.next==null)
			return ln;
		ListNode secondNode=ln.next;
		ln.next=null;
		ListNode reverseNode=reverseLL(secondNode);
		secondNode.next=ln;
		return reverseNode;
	}
}
