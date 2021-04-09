package April2021Leetcode;

public class _0042TrappingRainWater {

	public static void main(String[] args) {
		System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
		System.out.println(trap(new int[] { 4, 2, 0, 3, 2, 5 }));
	}

	public static int trap(int[] height) {
		if (height == null || height.length < 2)
			return 0;
		int[] left = new int[height.length];
		int[] right = new int[height.length];

		left[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			left[i] = Math.max(left[i - 1], height[i]);
		}

		right[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], height[i]);
		}

		int res = 0;
		for (int i = 0; i < right.length; i++) {
			res += Math.min(left[i], right[i]) - height[i];
		}
		return res;
	}
}
