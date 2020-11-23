package Nov2020Leetcode;

import java.util.Arrays;

public class _0733FloodFill {
	public static void main(String[] args) {
		int[][] out = floodFill(new int[][] { new int[] { 1, 1, 1 }, new int[] { 1, 1, 0 }, new int[] { 1, 0, 1 } }, 1,
				1, 2);
		for (int i = 0; i < out.length; i++) {
			System.out.println(Arrays.toString(out[i]));
		}

		out = floodFill(new int[][] { new int[] { 0, 0, 0 }, new int[] { 0, 1, 1 } }, 1, 1, 1);
		for (int i = 0; i < out.length; i++) {
			System.out.println(Arrays.toString(out[i]));
		}
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		floodFillValues(image, sr, sc, image[sr][sc], newColor);
		return image;
	}

	public static void floodFillValues(int[][] image, int x, int y, int currColor, int newColor) {
		if (x < 0 || x > image.length - 1 || y < 0 || y > image[0].length - 1 || image[x][y] != currColor || image[x][y] == newColor)
			return;
		image[x][y] = newColor;
		floodFillValues(image, x - 1, y, currColor, newColor);
		floodFillValues(image, x + 1, y, currColor, newColor);
		floodFillValues(image, x, y - 1, currColor, newColor);
		floodFillValues(image, x, y + 1, currColor, newColor);
	}
}
