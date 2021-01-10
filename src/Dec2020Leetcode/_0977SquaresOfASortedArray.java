package Dec2020Leetcode;

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
		while (left <= right) {
			int leftVal = nums[left];
			int rightVal = nums[right];

			if (leftVal * leftVal > rightVal * rightVal) {
				out[index] = leftVal * leftVal;
				left++;
			} else {
				out[index] = rightVal * rightVal;
				right--;
			}
			index--;
		}
		return out;
	}
}
