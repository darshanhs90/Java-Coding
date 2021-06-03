package May2021GoogLeetcode;

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
		dfs(image, sr, sc, image[sr][sc], newColor);
		return image;
	}

	public static void dfs(int[][] image, int sr, int sc, int origColor, int newColor) {
		if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != origColor)
			return;
		image[sr][sc] = newColor;
		dfs(image, sr - 1, sc, origColor, newColor);
		dfs(image, sr + 1, sc, origColor, newColor);
		dfs(image, sr, sc - 1, origColor, newColor);
		dfs(image, sr, sc + 1, origColor, newColor);
	}

}
