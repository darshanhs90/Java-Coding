package May2021GoogLeetcode;

public class _0727MinimumWindowSubsequence {
	public static void main(String[] args) {
		System.out.println(minWindow("abcdebdde", "bde"));
		System.out.println(minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "l"));
	}

	public static String minWindow(String s, String t) {
		if (s == null || s.length() == 0)
			return "";
		int minLen = Integer.MAX_VALUE;
		String minString = "";
		int right = 0;
		while (right < s.length()) {
			int tIndex = 0;
			while (right < s.length() && tIndex < t.length()) {
				if (s.charAt(right) == t.charAt(tIndex)) {
					tIndex++;
				}

				if (tIndex == t.length())
					break;

				right++;

			}
			if (tIndex < t.length()) {
				break;
			}

			tIndex = t.length() - 1;
			int left = right;
			while (tIndex >= 0) {
				if (s.charAt(left) == t.charAt(tIndex)) {
					tIndex--;
				}
				if (tIndex < 0)
					break;
				left--;

			}

			if (right - left + 1 < minLen) {
				minLen = right - left + 1;
				minString = s.substring(left, right + 1);
			}

			right = left + 1;
		}
		return minString;
	}

}
