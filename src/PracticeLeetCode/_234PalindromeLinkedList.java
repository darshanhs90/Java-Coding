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
		if(ln==null||ln.next==null)
			return true;
		int length=getLength(ln);
		ListNode first=ln;
		ListNode second=ln;
		if(length%2==0)
		{
			int count=0;
			while(count<(length/2)-1){
				ln=ln.next;
				count++;
			}
			ListNode temp=ln.next;
			ln.next=null;
			second=reverseLL(temp);
		}
		else{
			int count=0;
			while(count<(length/2)-1){
				ln=ln.next;
				count++;
			}
			ListNode temp=ln.next.next;
			ln.next=null;
			second=reverseLL(temp);
		}
		while(first!=null && second!=null)
		{
			System.out.println(first.val);
			System.out.println(second.val);
			if(first.val!=second.val)
				return false;
			first=first.next;
			second=second.next;
		}
		return first==null && second==null;
	}
	private static ListNode reverseLL(ListNode ln) {
		if(ln==null||ln.next==null)
			return ln;
		ListNode nextNode=ln.next;
		ListNode reverse=reverseLL(ln.next);
		nextNode.next=ln;
		ln.next=null;
		return reverse;
	}
	private static int getLength(ListNode ln) {
		return ln==null?0:1+getLength(ln.next);
	}

}