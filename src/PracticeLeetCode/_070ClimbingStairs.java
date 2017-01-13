package PracticeLeetCode;

import java.util.Arrays;

public class _070ClimbingStairs {
	public static void main(String[] args) {
		System.out.println(climbStairs(2));
	}
	public static int climbStairs(int n) {
		if(n<=0)
			return 0;
		return fib(n);
	}
	private static int fib(int n) {
		int[] fibo=new int[n+2];
		if(n==1)
			return 1;
		fibo[0]=0;
		fibo[1]=1;
		for (int i = 2; i < fibo.length; i++) {
			fibo[i]=fibo[i-1]+fibo[i-2];
		}
		System.out.println(Arrays.toString(fibo));
		return fibo[n+1];
	}
	

}

