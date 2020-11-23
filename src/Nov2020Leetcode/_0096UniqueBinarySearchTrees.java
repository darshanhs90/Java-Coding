package Nov2020Leetcode;

public class _0096UniqueBinarySearchTrees {

	public static void main(String[] args) {
		System.out.println(numTrees(1));
		System.out.println(numTrees(2));
		System.out.println(numTrees(3));
		System.out.println(numTrees(4));
		System.out.println(numTrees(5));
	}

	public static int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int nodesCount = 2; nodesCount <= n; nodesCount++) {
			for (int root = 1; root <= nodesCount; root++) {
				dp[nodesCount] += dp[nodesCount - root] * dp[root - 1];
			}
		}
		return dp[n];
	}
}
