package LeetCodePerformancePractice;

public class _143ReorderList {
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
		reorderList(ln);
	}

	private static ListNode reverseList(ListNode ln) {
		if(ln==null||ln.next==null)
			return ln;
		ListNode nextNode=ln.next;
		ln.next=null;
		ListNode reverse=reverseList(nextNode);
		nextNode.next=ln;
		return reverse;
	}
	public static void reorderList(ListNode head) {
		if(head==null||head.next==null)
			return;
		ListNode headPointer=head;
		ListNode fastPointer=head.next;
		ListNode slowPointer=head;
		while(fastPointer!=null)
		{
			if(fastPointer.next!=null){
				fastPointer=fastPointer.next.next;
				slowPointer=slowPointer.next;
			}
			else
			{
				break;
			}
		}
		ListNode reverseNode=slowPointer.next;
		slowPointer.next=null;
		reverseNode=reverseList(reverseNode);
		head=headPointer;
		while(head!=null && reverseNode!=null)
		{
			ListNode headNext=head.next;
			ListNode reverseNext=reverseNode.next;
			head.next=reverseNode;
			reverseNode.next=headNext;
			reverseNode=reverseNext;
			head=headNext;
		}
		head=headPointer;
		while(head!=null)
		{
			System.out.println(head.val);head=head.next;
		}
	}
}
