package June2021GoogLeetcode;

public class _0012IntegerToRoman {

	public static void main(String[] args) {
		System.out.println(intToRoman(3));
		System.out.println(intToRoman(4));
		System.out.println(intToRoman(9));
		System.out.println(intToRoman(58));
		System.out.println(intToRoman(1994));
	}

	public static String intToRoman(int num) {
		if (num <= 0)
			return "";
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			if (num >= 1000) {
				num -= 1000;
				sb.append("M");
			} else if (num >= 500) {
				if (num >= 900) {
					num -= 900;
					sb.append("CM");
				} else {
					num -= 500;
					sb.append("D");
				}
			} else if (num >= 100) {
				if (num >= 400) {
					num -= 400;
					sb.append("CD");
				} else {
					num -= 100;
					sb.append("C");
				}
			} else if (num >= 50) {
				if (num >= 90) {
					num -= 90;
					sb.append("XC");
				} else {
					num -= 50;
					sb.append("L");
				}
			} else if (num >= 10) {
				if (num >= 40) {
					num -= 40;
					sb.append("XL");
				} else {
					num -= 10;
					sb.append("X");
				}
			} else if (num >= 5) {
				if (num >= 9) {
					num -= 9;
					sb.append("IX");
				} else {
					num -= 5;
					sb.append("V");
				}
			} else {
				if (num >= 4) {
					num -= 4;
					sb.append("IV");
				} else {
					num -= 1;
					sb.append("I");
				}
			}
		}
		return sb.toString();
	}

}
