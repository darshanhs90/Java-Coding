package eBayPrep;

import java.util.Arrays;

public class _238ProductofArrayExceptSelf{

	public static int[] productExceptSelf(int[] nums) {
		int output[]=new int[nums.length];
		int temp1[]=new int[nums.length];
		int temp2[]=new int[nums.length];
		temp1[0]=1;
		temp2[nums.length-1]=1;
		for (int i = 0; i < nums.length-1; i++) {
			temp1[i+1]=nums[i]*temp1[i];
		}
		for (int i = nums.length-1; i >0; i--) {
			temp2[i-1]=nums[i]*temp2[i];
		}
		for (int i =0;i<nums.length;i++) {
			output[i]=temp1[i]*temp2[i];
		}
		return output;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
	}
}

