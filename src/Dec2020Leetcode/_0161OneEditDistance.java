package Dec2020Leetcode;

public class _0161OneEditDistance {
	public static void main(String[] args) {
		System.out.println(isOneEditDistance("ab", "acb"));
		System.out.println(isOneEditDistance("", ""));
		System.out.println(isOneEditDistance("a", ""));
		System.out.println(isOneEditDistance("", "A"));
	}

	public static boolean isOneEditDistance(String s, String t) {
		if (Math.abs(s.length() - t.length()) > 1)
			return false;

		int diff = 0;
		if (s.length() == t.length()) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != t.charAt(i)) {
					diff++;
				}
				if (diff > 1)
					return false;
			}
		} else {
			String st1 = s.length() > t.length() ? s : t;
			String st2 = s.length() > t.length() ? t : s;
			int i = 0, j = 0;
			while (i < st1.length() || j < st2.length()) {
				if (i < st1.length() && j < st2.length()) {
					if (st1.charAt(i) != st2.charAt(j)) {
						diff++;
						i++;
					} else {
						i++;
						j++;
					}
				} else if (i < st1.length() || j < st2.length()) {
					diff++;
					i++;
					j++;
				}
				if (diff > 1)
					return false;
			}
		}
		return diff == 1 ? true : false;
	}

}
