package LeetCodePerformancePractice;

public class _204CountPrimes {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(countPrimes(10));
	}
	public static int countPrimes(int n) {
		int count = 0;
		for (int i = 1; i < n; i++) {
			if (isPrime(i)) 
				count++;
		}
		return count;
	}
	private static boolean isPrime(int num) {
		if(num<=1)
			return false;
		for (int i=2;i*i<=num;i++) {
			if((num%i)==0)
				return false;
		}
		return true;
	}
}
