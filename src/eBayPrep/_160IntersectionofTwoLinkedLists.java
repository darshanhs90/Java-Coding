package eBayPrep;

public class _160IntersectionofTwoLinkedLists {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static void main(String[] args) {
		ListNode ln1=new ListNode(3);
		ListNode ln2=new ListNode(2);
		ln2.next=ln1;
		System.out.println(getIntersectionNode(ln1, ln2).val);

	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lengthA=getLength(headA);
		int lengthB=getLength(headB);
		if(lengthA>lengthB)
		{
			int diff=lengthA-lengthB;
			while(diff!=0)
			{
				headA=headA.next;diff--;
			}
			while(headA!=headB)
			{
				headA=headA.next;
				headB=headB.next;
			}
			return headA;		
		}
		else
		{
			int diff=lengthB-lengthA;
			while(diff!=0)
			{
				headB=headB.next;diff--;
			}
			while(headA!=headB)
			{
				headA=headA.next;
				headB=headB.next;
			}
			return headA;
		}
	}

	private static int getLength(ListNode headA) {
		if(headA==null)
			return 0;
		return 1+getLength(headA.next);
	}
}

