package Nov2020Leetcode;

public class _0441ArrangingCoins {

	public static void main(String[] args) {
		System.out.println(arrangeCoins(5));
		System.out.println(arrangeCoins(8));
	}

	public static int arrangeCoins(int n) {
		int counter = 0;
		int index = 1;
		while (n > 0) {
			n = n - index;
			if (n >= 0)
				counter++;
			index++;
		}
		return counter;
	}
}
