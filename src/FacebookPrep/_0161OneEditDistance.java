package FacebookPrep;

public class _0161OneEditDistance {
	public static void main(String[] args) {
		System.out.println(isOneEditDistance("ab", "acb"));
		System.out.println(isOneEditDistance("", ""));
		System.out.println(isOneEditDistance("a", ""));
		System.out.println(isOneEditDistance("", "A"));
		System.out.println(isOneEditDistance("a", "A"));
	}

	public static boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null)
			return false;
		if (Math.abs(s.length() - t.length()) > 1)
			return false;

		String smallString = "";
		String bigString = "";
		if (s.length() < t.length()) {
			smallString = s;
			bigString = t;
		} else {
			smallString = t;
			bigString = s;
		}

		int sIndex = 0, tIndex = 0;
		boolean diffFound = false;
		while (sIndex < smallString.length() && tIndex < bigString.length()) {
			if (smallString.charAt(sIndex) != bigString.charAt(tIndex)) {
				diffFound = true;
				if (smallString.length() == bigString.length()) {
					return smallString.substring(sIndex + 1).equals(bigString.substring(tIndex + 1));
				} else {
					return smallString.substring(sIndex).equals(bigString.substring(tIndex + 1));
				}
			}
			sIndex++;
			tIndex++;
		}
		return s.length() != t.length();
	}

}
