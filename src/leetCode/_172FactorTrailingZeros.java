package leetCode;

/*
 * Link : https://leetcode.com/problems/factorial-trailing-zeroes/
 */

public class _172FactorTrailingZeros {
	public static int trailingZeroes(int n) {
		int sum=0;
		int number=5,result=n;
		while(result>1){
			result=n/number;
			sum+=result;
			number=number*5;
		}
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(trailingZeroes(101));

	}
}