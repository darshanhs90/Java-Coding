package FacebookPrep;

public class _0043MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("2", "3"));
		System.out.println(multiply("123", "456"));
		System.out.println(multiply("140", "721"));
	}

	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		int length = num1.length() + num2.length();
		int[] output = new int[length];

		for (int i = num1.length() - 1; i >= 0; i--) {
			for (int j = num2.length() - 1; j >= 0; j--) {
				int val1 = Integer.parseInt(num1.charAt(i) + "");
				int val2 = Integer.parseInt(num2.charAt(j) + "");
				int index2 = i + j + 1;
				int index1 = i + j;

				int val = (val1 * val2) + output[index2];

				int a1 = val / 10;
				int a2 = val % 10;
				output[index2] = a2;
				output[index1] += a1;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < output.length; i++) {
			sb.append(output[i]);
		}

		while (sb.length() > 0 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);

		return sb.toString();
	}
}
