package Mar2021Leetcode;

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
		if (image[sr][sc] == newColor)
			return image;

		dfs(sr, sc, image, image[sr][sc], newColor);
		return image;
	}

	public static void dfs(int x, int y, int[][] image, int srcColor, int newColor) {
		if (x < 0 | y < 0 || x >= image.length || y >= image[0].length || image[x][y] != srcColor)
			return;

		image[x][y] = newColor;
		dfs(x - 1, y, image, srcColor, newColor);
		dfs(x + 1, y, image, srcColor, newColor);
		dfs(x, y - 1, image, srcColor, newColor);
		dfs(x, y + 1, image, srcColor, newColor);
	}

}
