package leetCode;

/*
 * Link : https://leetcode.com/problems/move-zeroes/
 */

public class _231PowerOfTwo {
	public static boolean isPowerOfTwo(int n) {
		if(n<1)
			return false;
		else if(n==1)
			return true;
		while(true)
		{
			if(n%2==1)
				return false;
			if(n/2==1 && n%2==0)
				return true;
			n=n/2;
			
		}
	}

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(128));
	}
}