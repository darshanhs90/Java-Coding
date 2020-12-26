package Dec2020Leetcode;

public class _0041FirstMissingPositive {
	// https://www.youtube.com/watch?v=2QugZILS_Q8
	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[] { 1, 2, 0 }));
		System.out.println(firstMissingPositive(new int[] { 3, 4, -1, 1 }));
		System.out.println(firstMissingPositive(new int[] { 1, 2, 3 }));
		System.out.println(firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
	}

	public static int firstMissingPositive(int[] nums) {
		int n = nums.length;
		boolean oneFound = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				oneFound = true;
			} else if (nums[i] <= 0 || nums[i] > n)
				nums[i] = 1;
		}

		if (!oneFound)
			return 1;

		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]);
			if (index == n) {
				nums[0] = -1 * Math.abs(nums[0]);
			} else {
				nums[index] = -1 * Math.abs(nums[index]);
			}
		}

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > 0)
				return i;
		}

		if (nums[0] > 0)
			return n;

		return n + 1;
	}
}
