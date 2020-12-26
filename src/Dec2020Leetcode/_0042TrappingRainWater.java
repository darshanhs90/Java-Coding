package Dec2020Leetcode;

public class _0042TrappingRainWater {

	public static void main(String[] args) {
		System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
		System.out.println(trap(new int[] { 4, 2, 0, 3, 2, 5 }));
	}

	public static int trap(int[] height) {
		if (height == null || height.length <= 1)
			return 0;
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		left[0] = height[0];
		for (int i = 1; i < left.length; i++) {
			if (height[i] > left[i - 1])
				left[i] = height[i];
			else {
				left[i] = left[i - 1];
			}
		}

		right[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i--) {
			if (height[i] > right[i + 1])
				right[i] = height[i];
			else {
				right[i] = right[i + 1];
			}
		}

		int sum = 0;
		for (int i = 0; i < right.length; i++) {
			sum += Math.min(left[i], right[i]) - height[i];
		}
		return sum;
	}
}
