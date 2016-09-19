package LeetCodePerformancePractice;

public class _092ReverseLinkedList2 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		/*ln.next.next=new ListNode(3);
		ln.next.next.next=new ListNode(4);
		ln.next.next.next.next=new ListNode(5);*/
		ln=reverseBetween(ln,1,2);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null||head.next==null||m>n||m==n)
			return head;
		ListNode headPointer=head;
		ListNode mthNode=null;
		ListNode nthNode=null;
		int count=1;
		ListNode mPrev=null;
		ListNode nNext=null;
		ListNode prev=null;
		while(head!=null)
		{
			if(m==count){
				mPrev=prev;
				mthNode=head;
			}
			else if(n==count){
				nthNode=head;
				nNext=head.next;
				break;
			}
			count++;
			prev=head;
			head=head.next;
		}
		nthNode.next=null;
		mPrev.next=null;
		ListNode rev=reverseLL(mthNode);
		mPrev.next=rev;
		ListNode pointer=rev;
		while(pointer!=null && pointer.next!=null)
			pointer=pointer.next;
		pointer.next=nNext;
		return headPointer;
	}

	private static ListNode reverseLL(ListNode ln) {
		if(ln==null ||ln.next==null)
			return ln;
		ListNode nextNode=ln.next;
		ln.next=null;
		ListNode rev=reverseLL(nextNode);
		nextNode.next=ln;
		return rev;
	}
}
