package May2021PrepLeetcode;

import java.util.Arrays;

public class _0977SquaresOfASortedArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortedSquares(new int[] { -4, -1, 0, 3, 10 })));
		System.out.println(Arrays.toString(sortedSquares(new int[] { -7, -3, 2, 3, 11 })));
	}

	public static int[] sortedSquares(int[] nums) {
		int[] out = new int[nums.length];
		int left = 0, right = nums.length - 1;
		int index = nums.length - 1;
		while (index >= 0) {
			if (nums[left] * nums[left] > nums[right] * nums[right]) {
				out[index] = nums[left] * nums[left];
				left++;
			} else {
				out[index] = nums[right] * nums[right];
				right--;
			}
			index--;
		}
		return out;
	}
}
