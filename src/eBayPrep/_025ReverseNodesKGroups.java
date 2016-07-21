package LeetCodePractice;

import java.util.Stack;

public class _025ReverseNodesKGroups {
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

		ln=reverseNodes(ln,3);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}

	private static ListNode reverseNodes(ListNode ln, int n) {
		Stack<Integer> stack=new Stack<>();
		ListNode head=ln;
		while(ln!=null)
		{	
			ListNode lnPointer=ln;
			int count=0;
			while(count<n && lnPointer!=null)
			{
				stack.push(lnPointer.val);
				lnPointer=lnPointer.next;
				count++;
			}
			while(!stack.isEmpty())
			{
				ln.val=stack.pop();
				ln=ln.next;
			}
		}
		return head;
	}

}
