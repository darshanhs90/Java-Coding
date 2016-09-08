package LeetCodePerformancePractice;

public class _160IntersectionOfLinkedLists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static void main(String[] args) {


	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int length1=getLength(headA);
		int length2=getLength(headB);
		if(length1>length2)
		{
			int diff=length1-length2;
			while(diff!=0)
			{
				headA=headA.next;
			}
			return intersection(headA,headB);
		}
		else{
			int diff=length2-length1;
			while(diff!=0)
			{
				headB=headB.next;
			}
			return intersection(headB,headA);
		}
	}
	private ListNode intersection(ListNode head1, ListNode head2) {
		while(head1!=null && head2!=null)
		{
			if(head1.val==head2.val)
				return head1;
			head1=head1.next;
			head2=head2.next;
		}
		return head1;
	}
	private int getLength(ListNode head) {
		return head!=null?1+getLength(head.next):0;
	}
}
