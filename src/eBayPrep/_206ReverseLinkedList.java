package LeetCodePractice;

import java.util.Stack;

public class _206ReverseLinkedList{
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static ListNode reverseList(ListNode head) {
		if(head==null || head.next==null)
			return head;
		ListNode ln1=head;
		Stack<ListNode> stack=new Stack<>();
		while(head!=null)
		{
			stack.push(head);
			head=head.next;
		}
		head=new ListNode(-1);
		ln1=head;
		while(!stack.isEmpty())
		{
			head.next=stack.pop();
			head=head.next;
		}
		head.next=null;
		return ln1.next;
	}
	

	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(3);
		ln=reverseList(ln);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
}

