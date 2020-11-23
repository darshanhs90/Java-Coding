package Nov2020Leetcode;

public class _0461HammingDistance {

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
	}

	public static int hammingDistance(int x, int y) {
		return Integer.bitCount(x ^ y);
	}
}
