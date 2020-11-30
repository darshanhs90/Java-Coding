package Nov2020_FBPrep;

public class _052Powxn {

	public static void main(String[] args) {
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));
		System.out.println(search(new int[] { 1 }, 0));
	}

	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int left = 0;
		int right = nums.length - 1;

	}
}
