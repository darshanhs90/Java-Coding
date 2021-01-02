package Dec2020Leetcode;

public class _0283MoveZeroes {

	public static void main(String[] args) {
		moveZeroes(new int[] { 0, 1, 0, 3, 12 });
	}

	public static void moveZeroes(int[] nums) {
		int nonZeroIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[nonZeroIndex] = nums[i];
				nonZeroIndex++;
			}
		}
		for (int i = nonZeroIndex; i < nums.length; i++) {
			nums[i] = 0;
		}
	}

}
