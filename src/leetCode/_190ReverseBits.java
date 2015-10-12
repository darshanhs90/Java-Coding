package leetCode;

/*
 * Link : https://leetcode.com/problems/reverse-bits/
 */

public class _190ReverseBits {
	public static int reverseBits(int n) {	
		StringBuilder sb=new StringBuilder(Integer.toBinaryString(n));
		if(n<0)
			 sb=new StringBuilder(Integer.toBinaryString(~n));
		int length=sb.length();
		sb=sb.reverse();
		for (int i = 0; i < String.valueOf(n).length()*4-length; i++) {
			sb=sb.append("0");
		}
		System.out.println(sb.toString());
		return Integer.parseInt(sb.toString(),2);
	}
	public static void main(String[] args) {
		System.out.println(reverseBits(-1));
	}
	
	
	
}