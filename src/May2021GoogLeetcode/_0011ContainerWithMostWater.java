package May2021GoogLeetcode;

public class _0011ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
		System.out.println(maxArea(new int[] { 1, 1 }));
		System.out.println(maxArea(new int[] { 4, 3, 2, 1, 4 }));
		System.out.println(maxArea(new int[] { 1, 2, 1 }));
	}

	public static int maxArea(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int max = 0, left = 0, right = nums.length - 1;
		while (left < right) {
			max = Math.max(max, (right - left) * Math.min(nums[left], nums[right]));
			if (nums[left] < nums[right])
				left++;
			else
				right--;
		}
		return max;
	}

}
