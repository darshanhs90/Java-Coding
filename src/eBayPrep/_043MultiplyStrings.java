package LeetCodePractice;

import java.math.BigInteger;

public class _043MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("123123123", "678678668676"));
	}

	public static String multiply(String num1, String num2) {
		BigInteger number1=new BigInteger(num1);
		BigInteger number2=new BigInteger(num2);
		return number1.multiply(number2).toString();
	}
}
