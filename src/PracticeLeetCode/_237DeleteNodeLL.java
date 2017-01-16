package PracticeLeetCode;

public class _237DeleteNodeLL {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {


	}
	public void deleteNode(ListNode node) {
		node.val=node.next.val;
		node.next=node.next.next;		
	}
}

