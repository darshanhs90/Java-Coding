package Dec2020Leetcode;

public class _0747LargestNumberAtLeastTwiceOfOthers {
	public static void main(String[] args) {
		System.out.println(dominantIndex(new int[] { 3, 6, 1, 0 }));
		System.out.println(dominantIndex(new int[] { 1, 2, 3, 4 }));
	}

	public static int dominantIndex(int[] nums) {
		int max = nums[0];
		int maxIndex = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
				maxIndex = i;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != max) {
				if (nums[i] * 2 <= max) {
					continue;
				}
				return -1;
			}
		}
		return maxIndex;
	}
}
