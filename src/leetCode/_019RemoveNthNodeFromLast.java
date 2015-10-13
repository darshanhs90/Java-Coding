package leetCode;

/*
 * Link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

public class _019RemoveNthNodeFromLast {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode headNode=head;
		ListNode forwardPointer=head,backwardPointer=head;
		int count=0;
		while(count<n)
		{
			forwardPointer=forwardPointer.next;
			count++;
		}

		if(forwardPointer==null){
			return head.next;
		}

		while(forwardPointer.next!=null)
		{
			backwardPointer=backwardPointer.next;
			forwardPointer=forwardPointer.next;
		}
		backwardPointer.next = backwardPointer.next.next;
		return headNode;
	}

	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		/*ln.next.next=new ListNode(3);
		ln.next.next.next=new ListNode(4);
		ln.next.next.next.next=new ListNode(5);*/
		ln=removeNthFromEnd(ln, 1);
		while(ln!=null)
		{
			System.out.print(ln.val+"//");
			ln=ln.next;
		}
	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}