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
	private static boolean isPalindrome(ListNode ln) {
		
		return ln==null?0:1+getLength(ln.next);
	}

}