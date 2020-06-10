package PracticeLeetCode;

public class _070ClimbingStairs {
	public static void main(String[] args) {
		System.out.println(climbStairs(1));
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(3));
	}

	public static int climbStairs(int n) {
		if(n <= 1)
			return n;
		return fibo(n);
	}
	
	public static int fibo(int n) {
		int[] fibo = new int[n + 1];
		fibo[0] = 1;
		fibo[1] = 1;
		for (int i = 2; i < fibo.length; i++) {
			fibo[i] = fibo[i - 1] + fibo [i - 2];
		}
		return fibo[n];
	}
	
}
