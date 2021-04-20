package April2021PrepLeetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _0001TwoSum {
	// https://web.archive.org/web/20210128075622/https://res.cloudinary.com/bbs1024/image/upload/v1562016221/Interview_Notes_-_Dropbox.pdf
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 3 }, 6)));
		System.out.println(sharpnessValue(new int[][] { new int[] { 1 }, new int[] { 2 }, new int[] { 3 } }));// 3
		System.out.println(sharpnessValue(new int[][] { new int[] { 1, 2, 3 } }));// 1
		System.out.println(sharpnessValue(new int[][] { new int[] { 3 } }));// 3
		System.out.println(
				sharpnessValue(new int[][] { new int[] { 5, 7, 2 }, new int[] { 7, 5, 8 }, new int[] { 9, 1, 5 } }));
	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { map.get(target - nums[i]), i };
			}
			map.put(nums[i], i);
		}
		return new int[] {};
	}

	public static int sharpnessValue(int[][] nums) {
		int rows = nums.length;
		int cols = nums[0].length;
		int[][] dp = new int[rows][cols];

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = nums[i][0];
		}

		for (int col = 1; col < cols; col++) {
			for (int row = 0; row < rows; row++) {

				int prevVal = dp[row][col - 1];
				if (row > 0) {
					prevVal = Math.max(prevVal, dp[row - 1][col - 1]);
				}

				if (row < rows - 1) {
					prevVal = Math.max(prevVal, dp[row + 1][col - 1]);
				}

				prevVal = Math.min(prevVal, nums[row][col]);
				dp[row][col] = prevVal;
			}
		}
		int max = Integer.MIN_VALUE;
		for (int row = 0; row < rows; row++) {

			max = Math.max(max, dp[row][cols - 1]);
		}
		return max;
	}

}
