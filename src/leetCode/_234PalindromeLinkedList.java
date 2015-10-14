package leetCode;

import java.util.Stack;

/*
 * Link : https://leetcode.com/problems/palindrome-linked-list/
 */

public class _234PalindromeLinkedList {
	public static boolean isPalindromeLong(ListNode head) {
		ListNode headNode=head;
		ListNode headNodeCopy=head;
		Stack<Integer> stack=new Stack<>();
		while(headNode!=null)
		{
			stack.push(headNode.val);
			headNode=headNode.next;
		}
		while(headNodeCopy!=null)
		{
			if(stack.pop()!=headNodeCopy.val)
				return false;
			headNodeCopy=headNodeCopy.next;
		}
		return true;
	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {

	}

}