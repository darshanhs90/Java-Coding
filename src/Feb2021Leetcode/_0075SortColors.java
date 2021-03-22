package Feb2021Leetcode;

public class _0075SortColors {

	public static void main(String[] args) {
		sortColors(new int[] { 2, 0, 2, 1, 1, 0 });
		sortColors(new int[] { 2, 0, 1 });
		sortColors(new int[] { 0 });
		sortColors(new int[] { 1 });
	}

	public static void sortColors(int[] nums) {
		int zeros = 0, ones = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				zeros++;
			else if (nums[i] == 1)
				ones++;
		}

		for (int i = 0; i < nums.length; i++) {
			if (zeros > 0) {
				nums[i] = 0;
				zeros--;
			} else if (ones > 0) {
				nums[i] = 1;
				ones--;
			} else {
				nums[i] = 2;
			}
		}
	}

}
