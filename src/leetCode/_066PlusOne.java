package leetCode;

import java.math.BigInteger;

/*
 * Link : https://leetcode.com/problems/plus-one/
 */

public class _066PlusOne {
	public int[] plusOne(int[] digits) {
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < digits.length; i++) {
			sb.append(digits[i]);
		}
		BigInteger b=new BigInteger(sb.toString());
		b=b.add(new BigInteger("1"));
		String outputString=b.toString();
		digits=new int[outputString.length()];
		for (int i = 0; i < digits.length; i++) {
			digits[i]=Integer.parseInt(outputString.charAt(i)+"");
		}
		return digits;
	}
	public static void main(String[] args) {

	}
}