package LeetCodePerformancePractice;

public class _206ReverseLinkedList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
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
    public static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
        	return head;
        ListNode secondNode=head.next;
        head.next=null;
        ListNode restList=reverseList(secondNode);
        secondNode.next=head;
        return restList;
    }
}
