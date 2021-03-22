package Feb2021Leetcode;

public class _0518CoinChangeII {

	public static void main(String[] args) {
		System.out.println(change(5, new int[] { 1, 2, 5 }));
		System.out.println(change(3, new int[] { 2 }));
		System.out.println(change(10, new int[] { 10 }));

	}

	static int count;

	public static int change(int amount, int[] coins) {
		count = 0;
		dfs(0, 0, amount, coins);
		return count;
	}

	public static void dfs(int index, int currAmount, int amount, int[] coins) {
		if (currAmount == amount) {
			count++;
			return;
		}

		if (currAmount > amount)
			return;

		for (int i = index; i < coins.length; i++) {
			dfs(i, currAmount + coins[i], amount, coins);
		}
	}

}
