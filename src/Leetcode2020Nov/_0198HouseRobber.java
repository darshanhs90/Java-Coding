package Leetcode2020Nov;

public class _0198HouseRobber {

	public static void main(String[] args) {
		System.out.println(rob(new int[] { 1, 2, 3, 1 }));
		System.out.println(rob(new int[] { 2, 7, 9, 3, 1 }));
		System.out.println(rob(new int[] { 1, 2 }));
		System.out.println(rob(new int[] { 1 }));
	}

	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		} else if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		return Math.max(Math.max(rob(nums, nums[1], 3), rob(nums, nums[1], 4)),
				Math.max(rob(nums, nums[0], 2), rob(nums, nums[0], 3)));
	}

	public static int rob(int[] nums, int initVal, int newIndex) {
		if (newIndex >= nums.length) {
			return initVal;
		}
		return Math.max(rob(nums, initVal + nums[newIndex], newIndex + 2),
				rob(nums, initVal + nums[newIndex], newIndex + 3));
	}
}
