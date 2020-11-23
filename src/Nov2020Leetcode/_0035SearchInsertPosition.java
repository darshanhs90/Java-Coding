package Nov2020Leetcode;

public class _0035SearchInsertPosition {

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 5));
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 2));
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 7));
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 0));
		System.out.println(searchInsert(new int[] { 1 }, 0));
	}

	public static int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if(target< nums[i] || target == nums[i])
			{
				return i;
			}
		}
		return nums.length;
	}
}
