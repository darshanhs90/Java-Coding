package Nov2020_GfG;

import java.util.Arrays;

public class _005ThreeSumClosest {

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[] { -7, 9, 8, 3, 1, 1 }, 2));
		System.out.println(threeSumClosest(new int[] { 5, 2, 7, 5 }, 13));
	}

	static int threeSumClosest(int[] array, int target) {
		Arrays.parallelSort(array);
		int minDiff = Integer.MAX_VALUE;
		int closestValue = Integer.MIN_VALUE;
		for (int i = 0; i < array.length - 2; i++) {
			int num1 = array[i];
			int left = i + 1;
			int right = array.length - 1;
			while (left < right) {
				int sum = num1 + array[left] + array[right];
				if (Math.abs(target - sum) < minDiff) {
					closestValue = sum;
					minDiff = Math.abs(target - sum);
				}
				if (sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}
		return closestValue;
	}
}
