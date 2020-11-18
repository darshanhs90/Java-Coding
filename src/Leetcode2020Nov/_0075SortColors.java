package Leetcode2020Nov;

public class _0075SortColors {

	public static void main(String[] args) {
		sortColors(new int[] { 2, 0, 2, 1, 1, 0 });
		sortColors(new int[] { 2, 0, 1 });
		sortColors(new int[] { 0 });
		sortColors(new int[] { 1 });
	}

	public static void sortColors(int[] nums) {
		int numOf0s = 0, numOf1s = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				numOf0s++;
			} else if (nums[i] == 1) {
				numOf1s++;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (numOf0s > 0) {
				nums[i] = 0;
				numOf0s--;
			} else if (numOf1s > 0) {
				nums[i] = 1;
				numOf1s--;
			} else {
				nums[i] = 2;
			}
		}
	}
}
