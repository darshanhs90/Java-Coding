package Dec2020Leetcode;

import java.util.Arrays;

public class _0453MinimumMovesToEqualArrayElements {

	public static void main(String[] args) {
		System.out.println(minMoves(new int[] { 1, 2, 3 }));
	}

	public static int minMoves(int[] nums) {
		int count = 0;
		Arrays.sort(nums);
		for (int i = nums.length - 1; i > 0; i--) {
			count += nums[i] - nums[0];
		}
		return count;
	}
}
