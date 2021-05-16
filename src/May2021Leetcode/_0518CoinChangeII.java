package May2021Leetcode;

import java.util.Arrays;

public class _0518CoinChangeII {

	public static void main(String[] args) {
		System.out.println(change(5, new int[] { 1, 2, 5 }));
		System.out.println(change(3, new int[] { 2 }));
		System.out.println(change(10, new int[] { 10 }));

	}

	public static int change(int amount, int[] coins) {
		Arrays.sort(coins);
		return combinations(0, 0, coins, amount);
	}

	public static int combinations(int index, int currSum, int[] coins, int amount) {
		if (currSum == amount)
			return 1;
		if (currSum > amount)
			return 0;

		int count = 0;
		for (int i = index; i < coins.length; i++) {
			count += combinations(i, currSum + coins[i], coins, amount);
		}
		return count;
	}

}
