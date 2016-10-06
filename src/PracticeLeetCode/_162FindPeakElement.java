package LeetCodePerformancePractice;

public class _162FindPeakElement {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[]{1,2}));
	}
	
}
