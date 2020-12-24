package Dec2020Leetcode;

public class _0026RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] { 1, 1, 2 }));
		System.out.println(removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
	}

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int prev = nums[0];
		int prevIndex = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != prev) {
				nums[prevIndex] = nums[i];
				prevIndex++;
				prev = nums[i];
			}
		}
		return prevIndex;
	}
}
