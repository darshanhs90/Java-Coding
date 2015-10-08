package leetCode;

/*
 * Link : https://leetcode.com/problems/move-zeroes/
 */

public class _283MoveZeroes {
	public static void moveZeroes(int[] nums) {
		int index=0,zeroCount=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=0)
			{
				nums[index]=nums[i];
				index++;
			}
			else{
				zeroCount++;
			}
		}
		for (int i = nums.length-zeroCount; i<nums.length; i++) {
			nums[i]=0;
		}
	}

	public static void main(String[] args) {
		moveZeroes(new int[]{0, 1, 0, 3, 12});
	}
}