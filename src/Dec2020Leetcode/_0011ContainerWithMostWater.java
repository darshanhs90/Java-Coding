package Dec2020Leetcode;

public class _0011ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
		System.out.println(maxArea(new int[] { 1, 1 }));
		System.out.println(maxArea(new int[] { 4, 3, 2, 1, 4 }));
		System.out.println(maxArea(new int[] { 1, 2, 1 }));
	}

	public static int maxArea(int[] height) {
		if (height == null || height.length < 2)
			return 0;
		int maxArea = 0;
		int left = 0, right = height.length - 1;
		maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));

		while (left < right) {
			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
			maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
		}
		return maxArea;
	}

}
