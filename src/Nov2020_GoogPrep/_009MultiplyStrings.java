package Nov2020_GoogPrep;

public class _009MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("2", "3"));
		System.out.println(multiply("123", "456"));
	}

	public static String multiply(String num1, String num2) {
		int[] out = new int[num1.length() + num2.length()];
		for (int i = num1.length() - 1; i >= 0; i--) {
			for (int j = num2.length() - 1; j >= 0; j--) {
				int p1 = i + j;
				int p2 = i + j + 1;
				int multValue = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				multValue += out[p2];
				out[p1] += multValue / 10;
				out[p2] = multValue % 10;
			}
		}
		StringBuilder sb = new StringBuilder("");
		int index = 0;
		while (index < out.length) {
			if (sb.length() == 0 && out[index] == 0) {
				index++;
			} else {
				sb.append(out[index]);
				index++;
			}
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}
}
