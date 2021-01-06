package Dec2020Leetcode;

public class _0415AddStrings {

	public static void main(String[] args) {
		System.out.println(addStrings("100", "999"));
		System.out.println(addStrings("100", "1"));
		System.out.println(addStrings("9", "9"));
		System.out.println(addStrings("408", "5"));
	}

	public static String addStrings(String num1, String num2) {

		StringBuilder sb = new StringBuilder();
		boolean hasCarry = false;
		int str1Index = num1.length() - 1, str2Index = num2.length() - 1;
		while (str1Index >= 0 || str2Index >= 0) {
			int sum = hasCarry ? 1 : 0;
			hasCarry = false;
			if (str1Index >= 0 && str2Index >= 0) {
				sum += num1.charAt(str1Index) - '0';
				sum += num2.charAt(str2Index) - '0';
				str1Index--;
				str2Index--;
			} else if (str1Index >= 0) {
				sum += num1.charAt(str1Index) - '0';
				str1Index--;
			} else if (str2Index >= 0) {
				sum += num2.charAt(str2Index) - '0';
				str2Index--;
			}

			if (sum > 9) {
				sum = sum - 10;
				hasCarry = true;
			}
			sb.append(sum);
		}

		if (hasCarry)
			sb.append("1");
		return sb.reverse().toString();
	}

}
