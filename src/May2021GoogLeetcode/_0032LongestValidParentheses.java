package May2021GoogLeetcode;

public class _0032LongestValidParentheses {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("(()"));
		System.out.println(longestValidParentheses(")()())"));
		System.out.println(longestValidParentheses(")((()))"));
		System.out.println(longestValidParentheses(")((())())"));
		System.out.println(longestValidParentheses("()((())())"));
		System.out.println(longestValidParentheses(""));
	}

	public static int longestValidParentheses(String s) {
		int[] dp = new int[s.length()];
		int maxLen = 0;
		for (int i = 1; i < dp.length; i++) {
			char c = s.charAt(i);
			if (c == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
				} else {
					if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
						dp[i] = i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] + dp[i - 1] + 2 : dp[i - 1] + 2;
					}
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}
		return maxLen;
	}
}
