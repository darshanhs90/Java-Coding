package LeetCodePractice;

import java.util.Stack;

public class _234PalindromeLinkedList{
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public boolean isPalindrome(ListNode head) {
		if(head==null||head.next==null)
			return true;
		Stack<Integer> stack=new Stack<>();
		ListNode pointer=head;
		while(head!=null)
		{
			stack.push(head.val);
			head=head.next;
		}
		while(pointer!=null)
		{
			if(pointer.val!=stack.pop())
				return false;
			pointer=pointer.next;
		}
		return true;
	}

}

