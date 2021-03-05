package FacebookPrep;

public class _0162FindPeakElement {
	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[] { 1, 2, 3, 1 }));
		System.out.println(findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 }));
		System.out.println(findPeakElement(new int[] { 1, 2 }));
	}

	public static int findPeakElement(int[] nums) {
		if (nums == null || nums.length <= 1)
			return 0;
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;

			if (nums[mid] > nums[mid + 1]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
