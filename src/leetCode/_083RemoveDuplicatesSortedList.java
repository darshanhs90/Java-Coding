package leetCode;

/*
 * Link : https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */

public class _083RemoveDuplicatesSortedList {
	 public static ListNode deleteDuplicates(ListNode head) {
	        if(head == null || head.next == null)
	            return head;
	 
	        ListNode prev = head;    
	        ListNode p = head.next;
	 
	        while(p != null){
	            if(p.val == prev.val){
	                prev.next = p.next;
	                p = p.next;
	            }else{
	                prev = p;
	                p = p.next; 
	            }
	        }
	 
	        return head;
	    }
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(1);
		ln.next.next=new ListNode(2);
		ln.next.next.next=new ListNode(3);
		ln.next.next.next.next=new ListNode(3);
		ln.next.next.next.next.next=new ListNode(4);
		ln=deleteDuplicates(ln);
		System.out.println("HERE");
		while(ln!=null){
			System.out.println(ln.val);
			ln=ln.next;
		}
	}
}