package LeetCodePerformancePractice;

public class _234PalindromeLinkedList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(1);
		
		System.out.println(isPalindrome(ln));
	}
	public static boolean isPalindrome(ListNode head) {
		if(head==null ||head.next==null)
			return true;
		ListNode slowPointer=head;
		ListNode fastPointer=head;
		while(fastPointer.next!=null && fastPointer.next.next!=null)
		{
			fastPointer=fastPointer.next.next;
			slowPointer=slowPointer.next;
		}


		ListNode newHead=slowPointer.next;
		slowPointer.next=null;
		ListNode p1=newHead;
		ListNode p2=p1.next;
		while(p1!=null&&p2!=null)
		{
			ListNode temp=p2.next;
			p2.next=p1;
			p1=p2;
			p2=temp;
		}
		newHead.next = null;
		newHead=p2==null?p1:p2;
		while(head!=null && newHead!=null)
		{
			if(head.val!=newHead.val)
				return false;
			head=head.next;
			newHead=newHead.next;
		}
		return true;
	}
}
