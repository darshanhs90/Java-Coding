package Feb2021Leetcode;

public class _0161OneEditDistance {
	public static void main(String[] args) {
		System.out.println(isOneEditDistance("ab", "acb"));
		System.out.println(isOneEditDistance("", ""));
		System.out.println(isOneEditDistance("a", ""));
		System.out.println(isOneEditDistance("", "A"));
		System.out.println(isOneEditDistance("a", "A"));
	}

	public static boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null || s.equals(t) || Math.abs(s.length() - t.length()) > 1)
			return false;

		String leftString = s, rightString = t;
		if (s.length() < t.length()) {
			leftString = t;
			rightString = s;
		}
		for (int i = 0; i < Math.min(leftString.length(), rightString.length()); i++) {
			if (leftString.charAt(i) != rightString.charAt(i)) {
				if (leftString.length() != rightString.length())
					return leftString.substring(i + 1).equals(rightString.substring(i));
				else {
					return leftString.substring(i + 1).equals(rightString.substring(i + 1));
				}
			}
		}

		return true;
	}

}
