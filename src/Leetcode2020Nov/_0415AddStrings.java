package Leetcode2020Nov;

public class _0415AddStrings {

	public static void main(String[] args) {
		System.out.println(addStrings("100", "999"));
		System.out.println(addStrings("100", "1"));
		System.out.println(addStrings("9", "9"));
		System.out.println(addStrings("408", "5"));
	}

	public static String addStrings(String num1, String num2) {
		String out = "";
		boolean hasCarry = false;
		int num1Index = num1.length() - 1;
		int num2Index = num2.length() - 1;
		while (num1Index > -1 || num2Index > -1) {
			int val = hasCarry ? 1 : 0;
			if (num1Index > -1) {
				val += Integer.valueOf(num1.charAt(num1Index) + "");
				num1Index--;
			}
			if (num2Index > -1) {
				val += Integer.valueOf(num2.charAt(num2Index) + "");
				num2Index--;
			}
			if (val > 9) {
				hasCarry = true;
				val = val - 10;
			} else {
				hasCarry = false;
			}
			out = val + out;
		}
		if (hasCarry) {
			out = "1" + out;
		}
		return out;
	}
}
