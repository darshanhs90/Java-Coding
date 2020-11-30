package Nov2020_FBPrep;

public class _054FindPeakElement {

	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[] { 1, 2, 3, 1 }));
		System.out.println(findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 }));
	}

	public static int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (left == right) {
				return left;
			} else if (nums[mid] > nums[mid + 1]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
