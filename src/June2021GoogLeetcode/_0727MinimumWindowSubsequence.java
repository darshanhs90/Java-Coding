package June2021GoogLeetcode;

public class _0727MinimumWindowSubsequence {
	public static void main(String[] args) {
		System.out.println(minWindow("abcdebdde", "bde"));
		System.out.println(minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "l"));
	}

	public static String minWindow(String s, String t) {
		int tIndex = 0;
		int left = 0, right = 0, minLength = Integer.MAX_VALUE;
		String minString = "";
		while (right < s.length()) {
			tIndex = 0;
			while (right < s.length()) {
				if (s.charAt(right) == t.charAt(tIndex)) {
					tIndex++;
				}

				if (tIndex == t.length())
					break;
				right++;
			}

			if (tIndex != t.length())
				return minString;
			tIndex = t.length() - 1;
			left = right;
			while (left >= 0 && tIndex >= 0) {
				if (s.charAt(left) == t.charAt(tIndex)) {
					tIndex--;
				}

				if (tIndex < 0)
					break;
				left--;
			}

			if (right - left + 1 < minLength) {
				minLength = right - left + 1;
				minString = s.substring(left, right + 1);
			}
			right = left + 1;

		}
		return minString;
	}

}
