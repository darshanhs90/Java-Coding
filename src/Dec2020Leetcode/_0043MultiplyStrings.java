package Dec2020Leetcode;

public class _0043MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("2", "3"));
		System.out.println(multiply("123", "456"));
		System.out.println(multiply("140", "721"));
	}

	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		int[] output = new int[num1.length() + num2.length()];

		for (int i = num2.length() - 1; i >= 0; i--) {
			for (int j = num1.length() - 1; j >= 0; j--) {
				int p1 = i + j;
				int p2 = i + j + 1;
				int val1 = Integer.parseInt(num2.charAt(i) + "");
				int val2 = Integer.parseInt(num1.charAt(j) + "");
				int result = output[p2] + val1 * val2;

				output[p1] += result / 10;
				output[p2] = result % 10;
			}
		}

		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < output.length; i++) {
			if ((output[i] == 0 && sb.length() != 0) || output[i] != 0)
				sb.append(output[i]);
		}

		return sb.toString();
	}
}
