package Leetcode2020Nov;

public class _0190ReverseBits {

	public static void main(String[] args) {
		System.out.println(reverseBits(10011100));
	}

	public static int reverseBits(int n) {
		StringBuilder val = new StringBuilder(String.valueOf(n));
		return Integer.parseInt(val.reverse().toString());
	}
}
