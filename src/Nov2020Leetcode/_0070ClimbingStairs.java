package Nov2020Leetcode;

public class _0070ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(0));
		System.out.println(climbStairs(1));
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(3));
	}

	public static int climbStairs(int n) {
		return fibo(n);
	}

	public static int fibo(int n) {
		if (n <= 1) {
			return n;
		}
		int[] fib = new int[n+1];
		fib[0] = 1;
		fib[1] = 1;
		for (int i = 2; i < fib.length; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}
}
