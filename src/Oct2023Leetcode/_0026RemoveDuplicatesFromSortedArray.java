package Oct2023Leetcode;

public class _0026RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] { 1, 1, 2 }));
		System.out.println(removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
	}

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == nums[index])
				continue;
			nums[index + 1] = nums[i];
			index += 1;
		}
		return index + 1;
	}
}
