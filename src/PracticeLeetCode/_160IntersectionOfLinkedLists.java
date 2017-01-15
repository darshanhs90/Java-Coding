package PracticeLeetCode;

public class _160IntersectionOfLinkedLists {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(3);
		ListNode ln1=new ListNode(2);
		ln1.next=ln;
		ln=getIntersectionNode(ln, ln1);
		System.out.println(ln.val);

	}
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if((headA==null && headB==null)||(headA==null|headB==null))
			return null;
		int lengthA=getLength(headA);
		int lengthB=getLength(headB);
		if(lengthA>lengthB)
		{
			int diff=lengthA-lengthB;
			while(diff>0)
			{
				headA=headA.next;
				diff--;
			}
			while(headA!=null && headB!=null && headA!=headB)
			{
				headA=headA.next;
				headB=headB.next;
			}
			return headA;
		}else{
			int diff=lengthB-lengthA;
			while(diff>0)
			{
				headB=headB.next;
				diff--;
			}
			while(headA!=null && headB!=null && headA!=headB)
			{
				headA=headA.next;
				headB=headB.next;
			}
			return headA;
		}

	}
	private static int getLength(ListNode headA) {
		return headA==null?0:1+getLength(headA.next);
	}
}
