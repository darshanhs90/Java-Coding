package PracticeLeetCode;

public class _070ClimbingStairs {
	public static void main(String[] args) {
		System.out.println(climbStairs(2));
	}
	public static int climbStairs(int n) {
		return fib(n);
	}
	private static int fib(int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		int[] fibo=new int[n+1];
		fibo[0]=1;
		fibo[1]=1;
		for (int i = 2; i < fibo.length; i++) {
			fibo[i]=fibo[i-1]+fibo[i-2];
		}
		return fibo[n];
	}

}

