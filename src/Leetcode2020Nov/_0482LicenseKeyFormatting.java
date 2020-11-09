package Leetcode2020Nov;

public class _0482LicenseKeyFormatting {

	public static void main(String[] args) {
		System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
		System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
	}

	public static String licenseKeyFormatting(String S, int K) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		boolean init = true;
		for (int i = S.length() - 1; i >= 0; i--) {
			char c = S.charAt(i);
			if (c != '-') {
				if (count == 0 && !init) {
					sb = sb.append("-");
				}
				init = false;
				count++;
				sb = sb.append(c);
			}

			if (count == K) {
				count = 0;
			}
		}
		return sb.reverse().toString().toUpperCase();
	}
}
