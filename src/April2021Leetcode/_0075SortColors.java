package April2021Leetcode;

public class _0075SortColors {

	public static void main(String[] args) {
		sortColors(new int[] { 2, 0, 2, 1, 1, 0 });
		sortColors(new int[] { 2, 0, 1 });
		sortColors(new int[] { 0 });
		sortColors(new int[] { 1 });
	}

	public static void sortColors(int[] nums) {
		if (nums == null || nums.length < 2)
			return;
		int noOfOnes = 0, noOfZeros = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				noOfZeros++;
			else if (nums[i] == 1)
				noOfOnes++;
		}

		for (int i = 0; i < nums.length; i++) {
			if (noOfZeros > 0) {
				nums[i] = 0;
				noOfZeros--;
			} else if (noOfOnes > 0) {
				nums[i] = 1;
				noOfOnes--;
			} else {
				nums[i] = 2;
			}
		}
	}

}
