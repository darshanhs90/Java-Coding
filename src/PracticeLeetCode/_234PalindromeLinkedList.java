package LeetCodePerformancePractice;

public class _234PalindromeLinkedList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(1);
		
		System.out.println(isPalindrome(ln));
	}
}