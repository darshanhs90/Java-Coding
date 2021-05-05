package April2021PrepLeetcode;

public class _0041FirstMissingPositive {
	// https://www.youtube.com/watch?v=2QugZILS_Q8
	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[] { 1, 2, 0 }));
		System.out.println(firstMissingPositive(new int[] { 3, 4, -1, 1 }));
		System.out.println(firstMissingPositive(new int[] { 1, 2, 3 }));
		System.out.println(firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
	}

	public static int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 1;
		boolean hasOne = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				hasOne = true;
				break;
			}
		}
		if (!hasOne)
			return 1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0 || nums[i] > nums.length) {
				nums[i] = 1;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]);
			if (index == nums.length) {
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
			return nums.length;
		return nums.length + 1;
	}
}
