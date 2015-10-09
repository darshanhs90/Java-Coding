package leetCode;

/*
 * Link : https://leetcode.com/problems/climbing-stairs/
 */

public class _070ClimbingStairs {
	public int climbStairs(int n) {
		if(n<2)
			return 1;
		else{
			int fn[]=new int[n];
			fn[0]=1;
			fn[1]=1;
			for (int i = 2; i < n; i++) {
				fn[i]=fn[i-1]+fn[i-2];
			}
			return fn[fn.length-1];
		}
	}
}