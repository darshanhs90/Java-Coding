package Nov2020Leetcode;

public class _0162FindPeakElement {
	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[] { 1, 2, 3, 1 }));
		System.out.println(findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 }));
	}

	public static int findPeakElement(int[] nums) {
		if (nums.length <= 1)
			return 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				if (nums[i] > nums[i + 1])
					return i;
			} else if (i == nums.length - 1) {
				if (nums[i] > nums[i - 1])
					return i;
			} else {
				if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
					return i;
			}
		}
		return -1;
	}
}
