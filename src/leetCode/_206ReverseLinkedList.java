package leetCode;

import java.util.Stack;

/*
 * Link : https://leetcode.com/problems/reverse-linked-list/
 */

public class _206ReverseLinkedList {
	public static ListNode reverseList(ListNode head) {
		Stack<ListNode> stack=new Stack<>();
		while(head!=null)
		{
			stack.push(head);
			head=head.next;
		}
		ListNode temp=new ListNode(0);
		ListNode next=new ListNode(0);
		temp.next=next;
		while(!stack.isEmpty())
		{
			next.next=new ListNode(stack.pop().val);
			next=next.next;
		}
		return temp.next.next;
	}

	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(1);
		ln.next.next=new ListNode(2);
		ln.next.next.next=new ListNode(3);
		ln.next.next.next.next=new ListNode(3);
		ln.next.next.next.next.next=new ListNode(4);
		ln=reverseList(ln);
		while(ln!=null){
			System.out.println(ln.val);
			ln=ln.next;
		}

	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}