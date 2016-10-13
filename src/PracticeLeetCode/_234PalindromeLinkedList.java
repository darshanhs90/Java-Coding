package PracticeLeetCode;

import PracticeLeetCode._002AddTwoNumbers.ListNode;

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
		//ln.next.next.next=new ListNode(1);
		System.out.println(isPalindrome(ln));
	}
	public static boolean isPalindrome(ListNode head) {
		if(head==null||head.next==null)
			return true;
		ListNode headPointer=head;
		ListNode fastPointer=head.next.next;
		while(fastPointer!=null && fastPointer.next!=null)
		{
			fastPointer=fastPointer.next;
			if(fastPointer.next!=null)
				fastPointer=fastPointer.next;
			head=head.next;
		}

		ListNode midPointer=head.next;
		head.next=null;
		midPointer=reverseLL(midPointer);
		while(midPointer!=null && headPointer!=null)
		{
			if(midPointer.val!=headPointer.val)
				return false;
			midPointer=midPointer.next;
			headPointer=headPointer.next;
		}
		return true;

	}
	private static ListNode reverseLL(ListNode ln) {
		if(ln==null||ln.next==null)
			return ln;
		ListNode nextNode=ln.next;
		ListNode reverse=reverseLL(nextNode);
		ln.next=null;
		nextNode.next=ln;
		return reverse;
	}
}