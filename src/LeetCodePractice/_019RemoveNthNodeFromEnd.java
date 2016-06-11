package LeetCodePractice;

public class _019RemoveNthNodeFromEnd {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x; 
		}
	}

	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		ln=removeNthFromEnd(ln, 1);
		while(ln!=null){
			System.out.println(ln.val);
			ln=ln.next;
		}
	}



	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode leadingPointer=head;
		ListNode laggingPointer=head;
		int count=0;
		while(count<n){
			leadingPointer=leadingPointer.next;
			count++;
		}
		if(leadingPointer==null)
			return head.next;
		
		while(leadingPointer.next!=null)
		{
			leadingPointer=leadingPointer.next;
			laggingPointer=laggingPointer.next;
		}
		laggingPointer.next=laggingPointer.next.next;
		return head;
	}
}
