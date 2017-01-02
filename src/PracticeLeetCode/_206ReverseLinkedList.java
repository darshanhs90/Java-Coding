package PracticeLeetCode;

public class _206ReverseLinkedList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(3);
		ln=reverseList(ln);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	private static ListNode reverseList(ListNode ln) {
		if(ln==null||ln.next==null)
			return ln;
		ListNode nextNode=ln.next;
		ListNode reverse=reverseList(ln.next);
		ln.next=null;
		nextNode.next=ln;
		return reverse;
	}


}