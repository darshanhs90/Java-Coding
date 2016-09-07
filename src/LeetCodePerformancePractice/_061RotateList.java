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
		ln=rotateRight(ln, 5);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	public static ListNode rotateRight(ListNode head, int k) {
		if(k<=0||head==null)
			return head;
		int length=findLength(head);
		k=k%length;
		if(k<=0||head==null)
			return head;
		ListNode prev=null;
		ListNode curr=head;
		for (int i = 0; i < length-k; i++) {
			prev=curr;
			curr=curr.next;
		}
		prev.next=null;
		ListNode newHead=curr;
		while(curr!=null &&curr.next!=null)
		{
			curr=curr.next;
		}
		curr.next=head;
		return newHead;
	}
	private static int findLength(ListNode head) {
		return head!=null?1+findLength(head.next):0;
	}
}

