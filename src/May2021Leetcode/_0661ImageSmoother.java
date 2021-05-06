package May2021Leetcode;

import java.util.Arrays;

public class _0661ImageSmoother {

	public static void main(String[] args) {
		int[][] image = new int[][] { new int[] { 1, 1, 1 }, new int[] { 1, 0, 1 }, new int[] { 1, 1, 1 } };
		image = imageSmoother(image);
		for (int i = 0; i < image.length; i++) {
			System.out.println(Arrays.toString(image[i]));
		}
	}

	public static int[][] imageSmoother(int[][] M) {
		
	}

}
