package Jan2021Leetcode;

public class _0287FindTheDuplicateNumber {

	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
		System.out.println(findDuplicate(new int[] { 3, 1, 3, 4, 2 }));
		System.out.println(findDuplicate(new int[] { 1, 1 }));
		System.out.println(findDuplicate(new int[] { 1, 1, 2 }));
	}

	public static int findDuplicate(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0)
				return index + 1;

			nums[index] = -1 * Math.abs(nums[index]);
		}
		return -1;
	}
}
