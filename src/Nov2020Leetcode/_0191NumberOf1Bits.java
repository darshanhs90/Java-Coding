package Nov2020Leetcode;

public class _0191NumberOf1Bits {

	public static void main(String[] args) {
		System.out.println(hammingWeight(00000000000000000000000000001011));
		System.out.println(hammingWeight(00000000000000000000000010000000));
		//System.out.println(hammingWeight(11111111111111111111111111111101));
	}

	public static int hammingWeight(int n) {
		String str = Integer.toBinaryString(n);
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			count += str.charAt(i) == '1' ? 1 : 0;
		}
		return count;
	}
}
