package eBayPrep;

public class _070ClimbingStairs {


	public static void main(String[] args) {
		System.out.println(climbStairs(2));
	}


	public static int climbStairs(int n) {
		return fibonacci(n+1);
	}


	private static int fibonacci(int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		else
			return fibonacci(n-1)+fibonacci(n-2);
	}
}

