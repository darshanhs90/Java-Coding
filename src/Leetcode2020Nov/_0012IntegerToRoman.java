package Leetcode2020Nov;

public class _0012IntegerToRoman {

	public static void main(String[] args) {
		System.out.println(intToRoman(3));
		System.out.println(intToRoman(4));
		System.out.println(intToRoman(9));
		System.out.println(intToRoman(58));
		System.out.println(intToRoman(1994));
	}

	public static String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			if (num >= 1000) {
				sb = sb.append("M");
				num -= 1000;
			} else if (num >= 500) {
				if (num >= 900) {
					sb = sb.append("CM");
					num -= 900;
				} else {
					sb = sb.append("D");
					num -= 500;
				}
			} else if (num >= 100) {
				if (num >= 400) {
					sb = sb.append("CD");
					num -= 400;
				} else {
					sb = sb.append("C");
					num -= 100;
				}
			} else if (num >= 50) {
				if (num >= 90) {
					sb = sb.append("XC");
					num -= 90;
				} else {
					sb = sb.append("L");
					num -= 50;
				}
			} else if (num >= 10) {
				if (num >= 40) {
					sb = sb.append("XL");
					num -= 40;
				} else {
					sb = sb.append("X");
					num -= 10;
				}
			} else if (num >= 5) {
				if (num >= 9) {
					sb = sb.append("IX");
					num -= 9;
				} else {
					sb = sb.append("V");
					num -= 5;
				}
			} else {
				if (num >= 4) {
					sb = sb.append("IV");
					num -= 4;
				} else {
					sb = sb.append("I");
					num -= 1;
				}
			}
		}
		return sb.toString();
	}
}
