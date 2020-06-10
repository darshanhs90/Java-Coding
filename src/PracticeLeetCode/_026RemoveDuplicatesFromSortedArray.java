package PracticeLeetCode;

public class _026RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] {1,1,2}));
		System.out.println(removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
	}

	public static int removeDuplicates(int[] nums) {
		if (nums == null) {
			return 0;
		} else if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}

		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[index] != nums[i]) {
				index++;
				nums[index] = nums[i];
			}
		}
		return index + 1;
	}

}
