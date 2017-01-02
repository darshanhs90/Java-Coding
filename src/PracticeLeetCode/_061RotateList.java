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
		ln=rotateRight(ln, 10);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	public static ListNode rotateRight(ListNode head, int k) {
		if(head==null||head.next==null||k==0)
			return head;
		int length=getHeight(head);
		if(k>length)
			k=k%length;
		if(k==length||k==0)
			return head;
		int count=length-k;
		ListNode pointer=head;
		while(count>1)
		{
			head=head.next;
			count--;
		}
		ListNode nextNode=head.next;
		ListNode outputPointer=nextNode;
		head.next=null;
		head=nextNode;
		while(head!=null && head.next!=null)
		{
			head=head.next;
		}
		if(head!=null)
			head.next=pointer;
		return outputPointer;

	}
	private static int getHeight(ListNode head) {
		return head==null?0:1+getHeight(head.next);
	}
}

