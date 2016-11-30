package eBayPrep;

import java.util.Arrays;

public class _260SingleNumber3{
	public static void main(String[] args) {
		System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 1, 3, 2, 5})));

	}
	public static int[] singleNumber(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[Math.abs(nums[i])]=-1*nums[Math.abs(nums[i])];
		}
		int[] output=new int[2];
		int index=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]<0)
			{
				output[index]=Math.abs(nums[i]);
				index++;
			}
		}
		return output;
	}
}

