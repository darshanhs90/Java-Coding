package leetCode;

/*
 * Link : https://leetcode.com/problems/number-of-1-bits/
 */

public class _191NoOf1Bits {
	public int hammingWeight(int n) {
		String binaryString=Integer.toBinaryString(n);
		int count=0;
		for (int j = 0; j < binaryString.length(); j++) {
			if(Integer.parseInt(binaryString.charAt(j)+"")==1)
				count++;
		}
		return count;
	}
}