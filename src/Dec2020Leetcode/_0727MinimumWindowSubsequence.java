package Dec2020Leetcode;

public class _0727MinimumWindowSubsequence {
	public static void main(String[] args) {
		System.out.println(minWindow("abcdebdde", "bde"));
		System.out.println(minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "l"));
	}

	public static String minWindow(String S, String T) {
		int minLength = Integer.MAX_VALUE;
		String minString = "";
		for (int i = 0; i < S.length() - T.length()+1; i++) {
			if (S.charAt(i) == T.charAt(0)) {
				String str = getMatch(i, S, T);
				if (str.length() != 0 && str.length() < minLength) {
					minLength = str.length();
					minString = str;
				}
			}
		}
		return minString;
	}

	public static String getMatch(int index, String S, String T) {
		int tIndex = 0;
		int i = index;
		for (i = index; i < S.length() && tIndex < T.length(); i++) {
			if (S.charAt(i) == T.charAt(tIndex)) {
				tIndex++;
			}
		}
		return tIndex == T.length() ? S.substring(index, i) : "";
	}

}
