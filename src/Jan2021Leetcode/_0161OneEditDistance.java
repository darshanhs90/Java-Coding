package Jan2021Leetcode;

public class _0161OneEditDistance {
	public static void main(String[] args) {
		System.out.println(isOneEditDistance("ab", "acb"));
		System.out.println(isOneEditDistance("", ""));
		System.out.println(isOneEditDistance("a", ""));
		System.out.println(isOneEditDistance("", "A"));
	}

	public static boolean isOneEditDistance(String s, String t) {
		if (s.equals(t))
			return false;
		if (Math.abs(s.length() - t.length()) > 1)
			return false;

		int sIndex = 0, tIndex = 0;

		String str1 = "";
		String str2 = "";
		if (s.length() > t.length()) {
			str1 = s;
			str2 = t;
		} else {
			str1 = t;
			str2 = s;
		}

		boolean diffFound = false;
		while (sIndex < str1.length() && tIndex < str2.length()) {
			if (str1.charAt(sIndex) != str2.charAt(tIndex)) {
				if (diffFound)
					return false;
				diffFound = true;
				if (str1.length() == str2.length()) {
					sIndex++;
					tIndex++;
				} else {
					sIndex++;
				}
			} else {
				sIndex++;
				tIndex++;
			}
		}

		return true;
	}

}
