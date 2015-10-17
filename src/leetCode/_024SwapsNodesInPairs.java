package leetCode;

/*
 * Link : https://leetcode.com/problems/swap-nodes-in-pairs/
 */

public class _024SwapsNodesInPairs {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static ListNode swapPairs(ListNode head) {
		ListNode headNode=head;
		ListNode pointer=head;
		while(pointer!=null)
		{
			if(pointer.next!=null)
			{
				int val=pointer.val;
				pointer.val=pointer.next.val;
				pointer.next.val=val;
				pointer=pointer.next.next;
			}
			else{
				break;
			}
		}
		return headNode;
	}
	
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(3);
		ln.next.next.next=new ListNode(4);
		ln=swapPairs(ln);
		while(ln!=null)
		{
			System.out.print(ln.val+"/");
			ln=ln.next;
		}
		
	}
}