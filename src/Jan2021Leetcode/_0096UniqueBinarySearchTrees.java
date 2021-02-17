package Jan2021Leetcode;

public class _0096UniqueBinarySearchTrees {

	public static void main(String[] args) {
		System.out.println(numTrees(1));
		System.out.println(numTrees(2));
		System.out.println(numTrees(3));
		System.out.println(numTrees(4));
		System.out.println(numTrees(5));
	}

	public static int numTrees(int n) {
		if (n < 0)
			return 0;
		else if (n <= 1)
			return n;

		int[] dp = new int[n + 2];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i < dp.length; i++) {
			int val = 0;
			for (int j = 1; j <= i; j++) {
				val += dp[j] * dp[i - j];
			}
			dp[i] = val;
		}
		return dp[n+1];
	}

}
