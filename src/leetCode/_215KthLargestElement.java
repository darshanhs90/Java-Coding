package leetCode;

import java.util.Arrays;

/*
 * Link : https://leetcode.com/problems/kth-largest-element-in-an-array/
 */

public class _215KthLargestElement {
	public  static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length-k];
	}


	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
	}
}