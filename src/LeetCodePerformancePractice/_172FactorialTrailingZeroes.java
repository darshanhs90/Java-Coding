package LeetCodePerformancePractice;

public class _172FactorialTrailingZeroes {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static void main(String[] args) {
		System.out.println(trailingZeroes(1808548329));
	}
	public static int trailingZeroes(int n) {
		if(n<0)
			return -1;
		int count=0;
		long div=5;
		while((n/div)>=1)
		{
			count+=n/div;
			div=div*5;
		}
		return count;
	}

}