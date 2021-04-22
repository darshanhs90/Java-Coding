package April2021PrepLeetcode;

public class _0415AddStrings {

	public static void main(String[] args) {
		System.out.println(addStrings("100", "999"));
		System.out.println(addStrings("100", "1"));
		System.out.println(addStrings("9", "9"));
		System.out.println(addStrings("408", "5"));
	}

	public static String addStrings(String num1, String num2) {
		int num1Index = num1.length() - 1;
		int num2Index = num2.length() - 1;
		StringBuilder sb = new StringBuilder();
		boolean hasCarry = false;
		while (num1Index >= 0 || num2Index >= 0) {
			int val = hasCarry ? 1 : 0;
			hasCarry = false;
			if (num1Index >= 0 && num2Index >= 0) {
				val += num1.charAt(num1Index) - '0' + num2.charAt(num2Index) - '0';
			} else if (num1Index >= 0) {
				val += num1.charAt(num1Index) - '0';
			} else {
				val += num2.charAt(num2Index) - '0';
			}
			num1Index--;
			num2Index--;
			if (val > 9) {
				hasCarry = true;
				val = val - 10;
			}
			sb.append(val);
		}
		if (hasCarry)
			sb.append('1');
		return sb.reverse().toString();
	}

}
