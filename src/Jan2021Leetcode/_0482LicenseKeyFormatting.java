package Jan2021Leetcode;

public class _0482LicenseKeyFormatting {

	public static void main(String[] args) {
		System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
		System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
	}

	public static String licenseKeyFormatting(String S, int K) {
		StringBuilder sb = new StringBuilder();
		int currcount = 0;
		for (int i = S.length() - 1; i >= 0; i--) {
			char c = S.charAt(i);
			if (c != '-') {
				sb.append(Character.toUpperCase(c));
				currcount++;
				if (currcount == K) {
					currcount = 0;
					sb.append("-");
				}
			}
		}
		sb = sb.reverse();
		if (sb.length() > 0 && sb.charAt(0) == '-')
			return sb.substring(1);
		return sb.toString();
	}
}
