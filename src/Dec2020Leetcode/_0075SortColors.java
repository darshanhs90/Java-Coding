package Dec2020Leetcode;

public class _0075SortColors {

	public static void main(String[] args) {
		sortColors(new int[] { 2, 0, 2, 1, 1, 0 });
		sortColors(new int[] { 2, 0, 1 });
		sortColors(new int[] { 0 });
		sortColors(new int[] { 1 });
	}

	public static void sortColors(int[] nums) {
		int noOf0s = 0, noOf1s = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				noOf0s++;
			else if (nums[i] == 1)
				noOf1s++;
		}

		for (int i = 0; i < nums.length; i++) {
			if (noOf0s > 0) {
				nums[i] = 0;
				noOf0s--;
			} else if (noOf1s > 0) {
				nums[i] = 1;
				noOf1s--;
			} else {
				nums[i] = 2;
			}
		}
	}

}
