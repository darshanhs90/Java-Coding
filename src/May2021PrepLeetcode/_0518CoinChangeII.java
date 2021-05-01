package May2021PrepLeetcode;

public class _0518CoinChangeII {

	public static void main(String[] args) {
		System.out.println(change(5, new int[] { 1, 2, 5 }));
		System.out.println(change(3, new int[] { 2 }));
		System.out.println(change(10, new int[] { 10 }));

	}

	public static int change(int amount, int[] coins) {
		return change(0, 0, coins, amount);
	}

	public static int change(int index, int sum, int[] coins, int amount) {
		if (sum == amount)
			return 1;
		if (index >= coins.length || sum > amount)
			return 0;
		int count = 0;
		for (int i = index; i < coins.length; i++) {
			count += change(i, sum + coins[i], coins, amount);
		}
		return count;
	}

}
