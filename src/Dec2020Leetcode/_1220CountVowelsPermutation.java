package Dec2020Leetcode;

public class _1220CountVowelsPermutation {
	public static void main(String[] args) {
		System.out.println(countVowelPermutation(1));
		System.out.println(countVowelPermutation(2));
		System.out.println(countVowelPermutation(5));
		System.out.println(countVowelPermutation(144));
	}

	public static int countVowelPermutation(int n) {
		long[][] dp = new long[n + 1][5];
		for (int i = 0; i < dp[0].length; i++) {
			dp[1][i] = 1;
		}
		int MOD = 1000000007;
		for (int i = 1; i < n; i++) {
			dp[i + 1][0] = (dp[i][1] + dp[i][2] + dp[i][4]) % MOD;
			dp[i + 1][1] = (dp[i][0] + dp[i][2]) % MOD;
			dp[i + 1][2] = (dp[i][1] + dp[i][3]) % MOD;
			dp[i + 1][3] = (dp[i][2]) % MOD;
			dp[i + 1][4] = (dp[i][2] + dp[i][3]) % MOD;
		}
		long ans = 0;
		for (int i = 0; i < 5; i++)
			ans = (ans + dp[n][i]) % MOD;
		return (int) ans;
	}
}
