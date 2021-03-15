package Feb2021Leetcode;

public class _0161OneEditDistance {
	public static void main(String[] args) {
		System.out.println(isOneEditDistance("ab", "acb"));
		System.out.println(isOneEditDistance("", ""));
		System.out.println(isOneEditDistance("a", ""));
		System.out.println(isOneEditDistance("", "A"));
	}

	public static boolean isOneEditDistance(String s, String t) {
		if (Math.abs(s.length() - t.length()) > 1 || s.equals(t))
			return false;

		for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				if (s.length() == t.length()) {
					return s.substring(i + 1).equals(t.substring(i + 1));
				} else {
					return s.substring(i).equals(t.substring(i + 1)) || s.substring(i + 1).equals(t.substring(i));
				}
			}
		}

		return true;
	}

}
