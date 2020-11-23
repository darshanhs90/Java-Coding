package Nov2020Leetcode;

import java.util.Arrays;

public class _1051HeightChecker {

	public static void main(String[] args) {
		System.out.println(heightChecker(new int[] { 1, 1, 4, 2, 1, 3 }));
		System.out.println(heightChecker(new int[] { 5, 1, 2, 3, 4 }));
		System.out.println(heightChecker(new int[] { 1, 2, 3, 4, 5 }));
	}

	public static int heightChecker(int[] heights) {
		int[] originalHeights = heights.clone();
		Arrays.parallelSort(heights);
		int count = 0;
		for (int i = 0; i < originalHeights.length; i++) {
			if (originalHeights[i] != heights[i]) {
				count++;
			}
		}
		return count;
	}
}
