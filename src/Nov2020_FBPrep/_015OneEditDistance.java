package Nov2020_FBPrep;

public class _015OneEditDistance {

	public static void main(String[] args) {
		System.out.println(isOneEditDistance("ab", "acb"));
		System.out.println(isOneEditDistance("", ""));
		System.out.println(isOneEditDistance("a", ""));
		System.out.println(isOneEditDistance("", "A"));
		System.out.println(isOneEditDistance("a", "ac"));
		System.out.println(isOneEditDistance("a", "A"));
		System.out.println(isOneEditDistance("ba", "a"));
	}

	public static boolean isOneEditDistance(String s, String t) {
		if (Math.abs(s.length() - t.length()) > 1)
			return false;

		int diff = 0;
		int index1 = 0, index2 = 0;

		while (index1 < s.length() || index2 < t.length()) {
			if (index1 < s.length() && index2 < t.length()) {
				char c1 = s.charAt(index1);
				char c2 = t.charAt(index2);
				if (c1 == c2) {
					index1++;
					index2++;
				} else {
					if (s.length() == t.length()) {
						index1++;
						index2++;
					} else if (s.length() > t.length()) {
						index1++;
					} else {
						index2++;
					}
					diff++;
				}
			} else if (index1 < s.length()) {
				index1++;
				diff++;
			} else if (index2 < t.length()) {
				index2++;
				diff++;
			}

			if (diff > 1)
				return false;
		}
		return diff == 1;
	}
}
