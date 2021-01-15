package Dec2020Leetcode;

public class _0518CoinChangeII {

	public static void main(String[] args) {
		System.out.println(change(5, new int[] { 1, 2, 5 }));
		System.out.println(change(3, new int[] { 2 }));
		System.out.println(change(10, new int[] { 10 }));

	}

	public static int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i < dp.length; i++) {
				dp[i] += dp[i - coin];
			}
		}

		return dp[amount];
	}

}
