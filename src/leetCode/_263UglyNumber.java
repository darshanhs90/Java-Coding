package leetCode;

/*
 * Link : https://leetcode.com/problems/ugly-number/
 */

public class _263UglyNumber {
	public static boolean isUgly(int num) {
		if(num<=0)
			return false;
		num=maxDivide(num,2);
		num=maxDivide(num,3);
		num=maxDivide(num,5);
		if(num==1)
			return true;
		return false;
	}
	private static int maxDivide(int num, int i) {
		while(num%i==0)
			num=num/i;
		return num;
	}
	public static void main(String[] args) {
		System.out.println(isUgly(0));
	}
}