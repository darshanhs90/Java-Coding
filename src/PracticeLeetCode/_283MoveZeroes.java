package PracticeLeetCode;

import java.util.Arrays;

public class _283MoveZeroes {
	public static void main(String[] args) {
		moveZeroes(new int[] {0,1,0,3,12});
	}

	public static void moveZeroes(int[] nums) {
		if(nums == null || nums.length == 1)
			return;
		int zeroIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != 0)
			{
				nums[zeroIndex] = nums[i];
				zeroIndex++;
			}
		}
		for (int i = zeroIndex; i < nums.length; i++) {
			nums[i] = 0;
		}
		System.out.println(Arrays.toString(nums));
	}

}
