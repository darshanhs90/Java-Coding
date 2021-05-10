package May2021Leetcode;

public class _0011ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
		System.out.println(maxArea(new int[] { 1, 1 }));
		System.out.println(maxArea(new int[] { 4, 3, 2, 1, 4 }));
		System.out.println(maxArea(new int[] { 1, 2, 1 }));
	}

	public static int maxArea(int[] nums) {
		int maxArea = 0;
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int currArea = (right - left) * Math.min(nums[left], nums[right]);
			maxArea = Math.max(maxArea, currArea);
			if (nums[left] < nums[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}

}
