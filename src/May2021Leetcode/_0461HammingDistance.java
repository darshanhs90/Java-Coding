package May2021Leetcode;

public class _0461HammingDistance {

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
	}

	public static int hammingDistance(int x, int y) {
		int count = 0;
		while (x > 0 || y > 0) {
			count += (x % 2 ^ y % 2);
			x >>= 1;
			y >>= 1;
		}
		return count;
	}
}
