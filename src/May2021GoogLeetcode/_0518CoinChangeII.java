package May2021GoogLeetcode;

import java.util.Arrays;

public class _0518CoinChangeII {

	public static void main(String[] args) {
		System.out.println(change(5, new int[] { 1, 2, 5 }));
		System.out.println(change(3, new int[] { 2 }));
		System.out.println(change(10, new int[] { 10 }));

	}

	static int count;

	public static int change(int amount, int[] coins) {
		Arrays.sort(coins);
		count = 0;
		change(0, 0, amount, coins);
		return count;
	}

	public static void change(int index, int curr, int amount, int[] coins) {
		if (curr == amount) {
			count++;
			return;
		}
		if (index >= coins.length || curr > amount)
			return;
		for (int i = index; i < coins.length; i++) {
			change(i, curr + coins[i], amount, coins);
		}
	}

}
