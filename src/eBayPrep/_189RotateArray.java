package LeetCodePractice;

import java.util.Arrays;

public class _189RotateArray {

	public static void main(String[] args) {
		rotate(new int[]{1,2,3,4,5,6,7},3);
	}

	public static void rotate(int[] nums, int k) {
		k=k>nums.length?k%nums.length:k;
		for (int i = 0; i <k; i++) {
			nums=rotateOnce(nums);
		}
		System.out.println(Arrays.toString(nums));
	}

	private static int[] rotateOnce(int[] nums) {
		int temp=nums[0];
		for (int i = 1; i < nums.length; i++) {
			int value=nums[i];
			nums[i]=temp;
			temp=value;
		}
		nums[0]=temp;
		return nums;
	}
}

