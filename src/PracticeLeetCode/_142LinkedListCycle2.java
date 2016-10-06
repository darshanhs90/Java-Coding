package LeetCodePerformancePractice;

public class _142LinkedListCycle2 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(3);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(0);
		ln.next.next.next=new ListNode(-4);
		ln.next.next.next.next=ln.next;
		System.out.println(detectCycle(ln));

	}
}