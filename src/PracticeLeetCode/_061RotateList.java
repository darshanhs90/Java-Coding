package PracticeLeetCode;

public class _061RotateList {
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
		ln=rotateRight(ln, 0);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	public static ListNode rotateRight(ListNode head, int k) {
		if(head==null||head.next==null)
			return head;
		int length=findLength(head);
		ListNode headNode=head;
		if(k>length)
			k=k%length;
		if(length==k|k==0)
			return head;
		for (int i = 0; i < length-k-1; i++) {
			head=head.next;
		}
		ListNode output=head.next;
		ListNode nextNode=output;
		head.next=null;
		while(nextNode.next!=null)
		{
			nextNode=nextNode.next;
		}
		nextNode.next=headNode;
		return output;
	}
	private static int findLength(ListNode head) {
		return head==null?0:1+findLength(head.next);
	}
}

