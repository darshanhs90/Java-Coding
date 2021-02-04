package Jan2021Leetcode;

public class _0075SortColors {

	public static void main(String[] args) {
		sortColors(new int[] { 2, 0, 2, 1, 1, 0 });
		sortColors(new int[] { 2, 0, 1 });
		sortColors(new int[] { 0 });
		sortColors(new int[] { 1 });
	}

	public static void sortColors(int[] nums) {
		int noOfOnes = 0;
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				nums[index] = 0;
				index++;
			} else if (nums[i] == 1)
				noOfOnes++;
		}
		while (index < nums.length) {
			if (noOfOnes > 0) {
				nums[index] = 1;
				noOfOnes--;
			} else {
				nums[index] = 2;
			}
			index++;
		}
	}

}
