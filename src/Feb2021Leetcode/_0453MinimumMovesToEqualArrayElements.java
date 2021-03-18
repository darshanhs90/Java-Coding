package Feb2021Leetcode;

import java.util.Arrays;

public class _0453MinimumMovesToEqualArrayElements {

	public static void main(String[] args) {
		System.out.println(minMoves(new int[] { 1, 2, 3 }));
	}

	public static int minMoves(int[] nums) {
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			count += nums[i] - nums[0];
		}
		return count;
	}
}
