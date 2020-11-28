package Nov2020_FBPrep;

public class _005RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] { 1, 1, 2 }));
		System.out.println(removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
	}

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int prevNum = nums[0];
		int index = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != prevNum) {
				nums[index] = nums[i];
				prevNum = nums[i];
				index++;
			}
		}
		return index;
	}
}
