package leetCode;

import java.math.BigInteger;

/*
 * Link : https://leetcode.com/problems/reverse-bits/
 */

public class _190ReverseBits {
	public static int reverseBits1(int n) {	
		StringBuilder sb=new StringBuilder(Integer.toBinaryString(n));
		if(n<0){
			System.out.println(Integer.toBinaryString(~n));
			BigInteger bigint=new BigInteger(Integer.toBinaryString(~n));
			System.out.println(bigint);
			bigint=bigint.add(new BigInteger("1"));
			System.out.println(bigint);
			sb=new StringBuilder(bigint.toString());
		}
		int length=sb.length();
		sb=sb.reverse();
		for (int i = 0; i < String.valueOf(n).length()*4-length; i++) {
			sb=sb.append("0");
		}
		System.out.println(sb.toString());
		return Integer.parseInt(sb.toString(),2);
	}
	public static void main(String[] args) {
		System.out.println(reverseBits1(-10));
		System.out.println(reverseBits1(10));
		
	}

	public static int reverseBits(int n) {
		for (int i = 0; i < 16; i++) {
			n = swapBits(n, i, 32 - i - 1);
		}
	 
		return n;
	}
	 
	public static int swapBits(int n, int i, int j) {
		int a = (n >> i) & 1;
		int b = (n >> j) & 1;
	 
		if ((a ^ b) != 0) {
			return n ^= (1 << i) | (1 << j);
		}
	 
		return n;
	}

}