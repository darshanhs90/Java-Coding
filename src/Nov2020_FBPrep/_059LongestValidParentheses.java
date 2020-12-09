package Nov2020_FBPrep;

public class _059LongestValidParentheses {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("(()"));
		System.out.println(longestValidParentheses(")()())"));
		System.out.println(longestValidParentheses(""));
	}

	public static int longestValidParentheses(String s) {
		if (s == null || s.length() < 2)
			return 0;
		int[] dp = new int[s.length()];
		dp[0] = 0;
		int max = 0;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				dp[i] = 0;
			} else if (c == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = ((i - 2) >= 0 ? dp[i - 2] : 0) + 2;
				} else {
					if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
						dp[i] = dp[i - 1] + 2 + ((i - 2 - dp[i - 1] >= 0) ? dp[i - 2 - dp[i - 1]] : 0);
					} else {
						dp[i] = 0;
					}
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
