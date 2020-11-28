package Nov2020_GfG;

import java.util.Arrays;

public class _017RearrangeAString {

	public static void main(String[] args) {
		System.out.println(reArrangeString("AC2BEW3"));
		System.out.println(reArrangeString("ACCBA10D2EW30"));
	}

	static String reArrangeString(String s) {
		// code here
		char[] c = s.toCharArray();
		Arrays.parallelSort(c);
		int count = 0;
		boolean hasChar = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c.length; i++) {
			if (Character.isDigit(c[i])) {
				hasChar = true;
				count += Integer.valueOf(c[i] + "");
			} else {
				sb = sb.append(c[i]);
			}
		}
		if (hasChar)
			sb = sb.append(count);
		return sb.toString();
	}
}
