package leetCode;

/*
 * Link : https://leetcode.com/problems/happy-number/
 */

public class _202HappyNumber {
	public static boolean isHappy(int n) {
		String inputString=String.valueOf(n);
		while(inputString.length()>1)
		{
			int value=0;
			for (int i = 0; i < inputString.length(); i++) {
				value+=Math.pow(Integer.parseInt(inputString.charAt(i)+""),2);
			}
			inputString=String.valueOf(value);
		}
		return Integer.parseInt(inputString)==(1)||Integer.parseInt(inputString)==(7)?true:false;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}
}