package Nov2020_FBPrep;

public class _007MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("2", "3"));
		System.out.println(multiply("123", "456"));
	}

	public static String multiply(String num1, String num2) {
		int sumLength = num1.length() + num2.length();
		int[] sum = new int[sumLength];

		for (int i = num1.length() - 1; i >= 0; i--) {
			int num1Val = Integer.parseInt(num1.charAt(i) + "");
			for (int j = num2.length() - 1; j >= 0; j--) {
				int num2Val = Integer.parseInt(num2.charAt(j) + "");
				int pos1 = i + j, pos2 = i + j + 1;
				int multVal = sum[pos2] + num1Val * num2Val;
				sum[pos1] += multVal / 10;
				sum[pos2] = multVal % 10;
			}
		}
		StringBuilder sb = new StringBuilder();

		for (int num : sum) {
			if (num == 0 && sb.length() == 0)
				continue;
			sb = sb.append(num);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}
}
