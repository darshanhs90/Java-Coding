package April2021Leetcode;

public class _0011ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
		System.out.println(maxArea(new int[] { 1, 1 }));
		System.out.println(maxArea(new int[] { 4, 3, 2, 1, 4 }));
		System.out.println(maxArea(new int[] { 1, 2, 1 }));
	}

	public static int maxArea(int[] nums) {
		if (nums == null || nums.length < 2)
			return 0;
		int maxArea = 0;
		int left = 0, right = nums.length - 1;
		while (left < right) {
			maxArea = Math.max(maxArea, Math.min(nums[left], nums[right]) * (right - left));
			if (nums[left] < nums[right])
				left++;
			else
				right--;
		}
		return maxArea;
	}

}
