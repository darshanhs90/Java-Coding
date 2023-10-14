package Oct2023Leetcode;

import java.util.Arrays;

public class _0283MoveZeroes {

	public static void main(String[] args) {
		moveZeroes(new int[] { 0, 1, 0, 3, 12 });
	}

	public static void moveZeroes(int[] nums) {
		int numIndex = 0;
		for (int index = 0; index < nums.length; index++) {
			if (nums[index] != 0) {
				nums[numIndex] = nums[index];
				numIndex++;
			}
		}
		for (int i = numIndex; i < nums.length; i++) {
			nums[i] = 0;
		}
		System.out.println(Arrays.toString(nums));
	}

}
