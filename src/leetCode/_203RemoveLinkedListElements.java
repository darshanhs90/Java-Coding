package leetCode;


/*
 * Link : https://leetcode.com/problems/remove-linked-list-elements/
 */
public class _203RemoveLinkedListElements {
	public static ListNode removeElements(ListNode head, int val) {
		if(head==null)
			return null;
		ListNode headNode=head;
		ListNode pointer=new ListNode(10);
		pointer.next=head;
		while(pointer.next!=null)
		{	
			if(pointer.next.val==val){	
				pointer.next=pointer.next.next;
			}
			else{
				pointer=pointer.next;
			}
		}
		while(headNode!=null && headNode.val==val)
		{
			headNode=headNode.next;
		}
		return headNode;
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		//ln.next=new ListNode(2);
		//ln.next.next=new ListNode(6);
		//ln.next.next.next=new ListNode(3);
		//ln.next.next.next.next=new ListNode(4);
		//ln.next.next.next.next.next=new ListNode(5);
		//ln.next.next.next.next.next.next=new ListNode(6);
		ln=removeElements(ln, 1);
		while(ln!=null)
		{
			System.out.print(ln.val+"//");
			ln=ln.next;
		}
	}
}