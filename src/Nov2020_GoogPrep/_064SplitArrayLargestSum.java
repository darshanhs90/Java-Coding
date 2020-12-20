package Nov2020_GoogPrep;

public class _064SplitArrayLargestSum {

	public static void main(String[] args) {
		System.out.println(splitArray(new int[] { 7, 2, 5, 10, 8 }, 2));
		System.out.println(splitArray(new int[] { 1, 2, 3, 4, 5 }, 2));
		System.out.println(splitArray(new int[] { 1, 4, 4 }, 3));
	}

	public static int splitArray(int[] nums, int m) {
		int maxVal = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			maxVal = Math.max(nums[i], maxVal);
			sum += nums[i];
		}
		if (m == 1)
			return sum;

		int left = maxVal;
		int right = sum;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (isValidSplit(mid, nums, m)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static boolean isValidSplit(int val, int[] nums, int m) {
		int split = 1;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum > val) {
				split++;
				sum = nums[i];
				if (split > m)
					return false;
			}
		}
		return true;
	}
}
