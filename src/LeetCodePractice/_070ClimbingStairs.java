package LeetCodePractice;

public class _070ClimbingStairs {


	public static void main(String[] args) {
		System.out.println(climbStairs(2));
	}


	public static int climbStairs(int n) {
		return fibo(n);
	}


	private static int fibo(int n) {
		if(n==0)return 0;
		if(n==1)return 1;
		int[] fibArray=new int[n+2];
		fibArray[0]=1;
		fibArray[1]=1;
		for (int i = 2; i <=n; i++) {
			fibArray[i]=fibArray[i-1]+fibArray[i-2];
		}
		return fibArray[n];
	}
}

