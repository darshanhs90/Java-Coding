package leetCode;

import java.util.Arrays;

/*
 * Link : https://leetcode.com/problems/missing-number/
 */

public class _268MissingNumber {
	public static int missingNumber(int[] nums) {
		Arrays.sort(nums);
		if(nums.length==1)
			if(nums[0]==0)
				return nums[0]+1;
			else
				return nums[0]-1;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=i)
				return i;
		}
		return nums[nums.length-1]+1;
	}
	public static void main(String[] args) {
		System.out.println(missingNumber(new int[]{0,1,3}));
	}
}