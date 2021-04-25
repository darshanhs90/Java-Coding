package April2021PrepLeetcode;

public class _0011ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
		System.out.println(maxArea(new int[] { 1, 1 }));
		System.out.println(maxArea(new int[] { 4, 3, 2, 1, 4 }));
		System.out.println(maxArea(new int[] { 1, 2, 1 }));
	}

	public static int maxArea(int[] height) {
		int maxVal = 0;
		int left = 0, right = height.length - 1;
		while (left < right) {
			maxVal = Math.max(maxVal, (right - left) * Math.min(height[left], height[right]));

			if (height[left] < height[right])
				left++;
			else
				right--;
		}
		return maxVal;
	}

}
