package Jan2021Leetcode;

public class _0191NumberOf1Bits {

	public static void main(String[] args) {
		System.out.println(hammingWeight(00000000000000000000000000001011));
		System.out.println(hammingWeight(00000000000000000000000010000000));
	}

	public static int hammingWeight(int n) {
		int mask = 1;
		int noOfBits = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & mask) != 0)
				noOfBits++;
			mask <<= 1;
		}
		return noOfBits;
	}
}
