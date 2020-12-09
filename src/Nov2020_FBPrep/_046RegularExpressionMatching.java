package Nov2020_FBPrep;

public class _046RegularExpressionMatching {

	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("ab", ".*"));
		System.out.println(isMatch("aab", "c*a*b"));
		System.out.println(isMatch("mississippi", "mis*is*p*."));
	}

	public static boolean isMatch(String s, String p) {
		if (s.equals(p))
			return true;
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		// populate first Row;
		for (int j = 1; j < dp[0].length; j++) {
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 2];
			}
		}

		// populate first Row;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 2];
					if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1))
						dp[i][j] = dp[i][j] || dp[i - 1][j];

				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}
}
