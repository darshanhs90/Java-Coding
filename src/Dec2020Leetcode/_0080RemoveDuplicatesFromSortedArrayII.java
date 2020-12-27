package Dec2020Leetcode;

public class _0080RemoveDuplicatesFromSortedArrayII {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));
		System.out.println(removeDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }));
	}

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int count = 1;
		int prev = nums[0];
		int index = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == prev) {
				if (count < 2) {
					nums[index] = nums[i];
					index++;
					count++;
				}
			} else {
				nums[index] = nums[i];
				prev = nums[i];
				index++;
				count = 1;
			}
		}
		return index;
	}
}
