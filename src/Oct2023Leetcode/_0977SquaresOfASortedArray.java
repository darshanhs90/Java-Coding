package Oct2023Leetcode;

import java.util.Arrays;

public class _0977SquaresOfASortedArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortedSquares(new int[] { -4, -1, 0, 3, 10 })));
		System.out.println(Arrays.toString(sortedSquares(new int[] { -7, -3, 2, 3, 11 })));
	}

	public static int[] sortedSquares(int[] nums) {
		int[] output = new int[nums.length];
		int outIndex = nums.length - 1;
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int leftSquare = nums[left] * nums[left];
			int rightSquare = nums[right] * nums[right];
			if (leftSquare > rightSquare) {
				output[outIndex] = leftSquare;
				left++;
			} else {
				output[outIndex] = rightSquare;
				right--;
			}
			outIndex--;
		}
		return output;
	}
}
