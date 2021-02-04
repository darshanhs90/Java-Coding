package Jan2021Leetcode;

public class _0509FibonacciNumber {

	public static void main(String[] args) {
		System.out.println(fib(0));
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));
		System.out.println(fib(5));
	}

	public static int fib(int n) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		int[] fibo = new int[n + 1];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2; i < fibo.length; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}
		return fibo[n];
	}
}
