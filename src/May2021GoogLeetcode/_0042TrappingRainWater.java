package May2021GoogLeetcode;

public class _0042TrappingRainWater {

	public static void main(String[] args) {
		System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
		System.out.println(trap(new int[] { 4, 2, 0, 3, 2, 5 }));
	}

	public static int trap(int[] nums) {
		if (nums == null || nums.length < 2)
			return 0;
		int[] leftMax = new int[nums.length];
		int[] rightMax = new int[nums.length];
		leftMax[0] = nums[0];
		rightMax[nums.length - 1] = nums[nums.length - 1];

		for (int i = 1; i < nums.length; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
		}

		for (int i = nums.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
		}

		int sum = 0;
		for (int i = 0; i < rightMax.length; i++) {
			sum += Math.min(leftMax[i], rightMax[i]) - nums[i];
		}
		return sum;
	}
}
