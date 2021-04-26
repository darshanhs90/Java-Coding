package April2021PrepLeetcode;

import java.util.Arrays;

public class _0518CoinChangeII {

	public static void main(String[] args) {
		System.out.println(change(5, new int[] { 1, 2, 5 }));
		System.out.println(change(3, new int[] { 2 }));
		System.out.println(change(10, new int[] { 10 }));

	}

	static int count = 0;

	public static int change(int amount, int[] coins) {
		count = 0;
		Arrays.sort(coins);
		dfs(0, 0, amount, coins);
		return count;
	}

	public static void dfs(int index, int currAmount, int amount, int[] coins) {
		if (currAmount == amount) {
			count++;
			return;
		}
		if (index >= coins.length || currAmount > amount)
			return;

		for (int i = index; i < coins.length; i++) {
			dfs(i, currAmount + coins[i], amount, coins);
		}
	}

}
