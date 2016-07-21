package LeetCodePractice;

public class _160IntersectionofTwoLinkedLists {
	
	public static void main(String[] args) {
		ListNode ln1=new ListNode(3);
		ListNode ln2=new ListNode(2);
		ln2.next=ln1;
		System.out.println(getIntersectionNode(ln1, ln2));
		
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		int lengthA=0,lengthB=0;
		ListNode pointerA=headA,pointerB=headB;
		while(pointerA!=null)
		{
			pointerA=pointerA.next;
			lengthA++;
		}
		while(pointerB!=null)
		{
			pointerB=pointerB.next;
			lengthB++;
		}
		if(lengthA>lengthB)
		{
			int diff=lengthA-lengthB;
			for (int i = 0; i < diff; i++) {
				headA=headA.next;
			}
			while(headA!=null && headB!=null && headA!=headB )
			{
				headA=headA.next;
				headB=headB.next;
			}
		}
		else{
			int diff=lengthB-lengthA;
			for (int i = 0; i < diff; i++) {
				headB=headB.next;
			}
			while(headA!=null && headB!=null && headA!=headB)
			{
				headA=headA.next;
				headB=headB.next;
			}
		}		
		if(headA==headB)
			return headA;
		return null;

	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}

