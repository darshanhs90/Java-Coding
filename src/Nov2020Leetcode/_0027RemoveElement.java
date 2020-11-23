package Nov2020Leetcode;

public class _0027RemoveElement {

	public static void main(String[] args) {
		System.out.println(removeElement(new int[] { 3, 2, 2, 3 }, 3));
		System.out.println(removeElement(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2));
	}

	public static int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0)
			return 0;
		int itemPointer = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[itemPointer + 1] = nums[i];
				itemPointer++;
			}
		}
		return itemPointer + 1;
	}
}
