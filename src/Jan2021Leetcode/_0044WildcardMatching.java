package Jan2021Leetcode;

public class _0044WildcardMatching {
	// https://www.youtube.com/watch?v=3ZDZ-N0EPV0
	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a"));
		System.out.println(isMatch("aa", "*"));
		System.out.println(isMatch("cb", "?a"));
		System.out.println(isMatch("adceb", "*a*b"));
		System.out.println(isMatch("acdcb", "a*c?b"));
	}

	public static boolean isMatch(String s, String p) {
		if (s.length() == 0 && p.length() == 0)
			return true;
		else if (p.length() == 0)
			return false;
		StringBuilder newPattern = new StringBuilder();
		newPattern.append(p.charAt(0));
		for (int i = 1; i < p.length(); i++) {
			if (p.charAt(i) == '*' && newPattern.charAt(newPattern.length() - 1) == '*') {
				continue;
			} else {
				newPattern.append(p.charAt(i));
			}
		}

		boolean[][] dp = new boolean[s.length() + 1][newPattern.length() + 1];
		dp[0][0] = true;
		if (newPattern.charAt(0) == '*')
			dp[0][1] = true;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s.charAt(i - 1) == newPattern.charAt(j - 1) || newPattern.charAt(j - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (newPattern.charAt(j - 1) == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

}
