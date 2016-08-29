package LeetCodePerformancePractice;

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
		ln=rotateRight(ln, 2);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	public static ListNode rotateRight(ListNode head, int k) {
		if(k==0||head==null||head.next==null)
			return head;
		int length=findLength(head);
		k=k>length?k%length:k;
		if(k==0||k==length)
			return head;
		ListNode headPointer=head;
		ListNode prev=null;
		for (int i = 0; i < length-k; i++) {
			prev=head;
			head=head.next;
		}
		prev.next=null;
		ListNode newHead=head;
		while(head.next!=null)
		{
			head=head.next;
		}
		head.next=headPointer;
		return newHead;
	}
	private static int findLength(ListNode head) {
		if(head==null)
			return 0;
		return 1+findLength(head.next);
	}
}

