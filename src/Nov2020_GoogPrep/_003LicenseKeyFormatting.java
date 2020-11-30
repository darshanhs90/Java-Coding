package Nov2020_GoogPrep;

public class _003LicenseKeyFormatting {

	public static void main(String[] args) {
		System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
		System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
	}

	public static String licenseKeyFormatting(String S, int K) {
		StringBuilder sb = new StringBuilder();
		int currCount = 0;
		for (int i = S.length() - 1; i >= 0; i--) {
			if (S.charAt(i) == '-')
				continue;
			if (currCount == K) {
				sb = sb.append("-");
				currCount = 0;
			}
			sb = sb.append(S.charAt(i));
			currCount++;
		}
		return sb.reverse().toString().toUpperCase();
	}
}
