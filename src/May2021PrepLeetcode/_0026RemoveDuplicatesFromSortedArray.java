package May2021PrepLeetcode;

public class _0026RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] { 1, 1, 2 }));
		System.out.println(removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
	}

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int itemPointer = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[itemPointer]) {
				nums[itemPointer + 1] = nums[i];
				itemPointer++;
			}
		}
		return itemPointer + 1;
	}
}
