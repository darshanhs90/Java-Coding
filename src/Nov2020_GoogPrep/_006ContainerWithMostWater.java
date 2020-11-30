package Nov2020_GoogPrep;

public class _006ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
		System.out.println(maxArea(new int[] { 1, 1 }));
		System.out.println(maxArea(new int[] { 4, 3, 2, 1, 4 }));
		System.out.println(maxArea(new int[] { 1, 2, 1 }));
	}

	public static int maxArea(int[] height) {
		int maxArea = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
			if (height[right] > height[left]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}
}
