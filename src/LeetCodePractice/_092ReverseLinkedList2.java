package LeetCodePractice;

import java.util.Stack;

public class _092ReverseLinkedList2 {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(3);
		ln.next.next.next=new ListNode(4);
		ln.next.next.next.next=new ListNode(5);
		ln=reverseBetween(ln, 2, 4);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}

	}
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode headPointer=head;
		int index=1;
		while(index!=m)
		{
			head=head.next;
			index++;
		}
		Stack<Integer> stack=new Stack<>();
		ListNode startPointer=head;
		while(index<=n)
		{
			index++;
			stack.push(head.val);
			head=head.next;
		}
		while(!stack.isEmpty())
		{
			startPointer.val=stack.pop();
			startPointer=startPointer.next;
		}
		return headPointer;
	}
}

