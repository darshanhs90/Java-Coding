package April2021Leetcode;

public class _0463IslandPerimeter {

	public static void main(String[] args) {
		System.out.println(islandPerimeter(new int[][] { new int[] { 0, 1, 0, 0 }, new int[] { 1, 1, 1, 0 },
				new int[] { 0, 1, 0, 0 }, new int[] { 1, 1, 0, 0 }, }));

		System.out.println(islandPerimeter(new int[][] { new int[] { 1 } }));
		System.out.println(islandPerimeter(new int[][] { new int[] { 1, 0 } }));
	}

	public static int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					count += getCount(i, j, grid);
				}
			}
		}
		return count;
	}

	public static int getCount(int x, int y, int[][] grid) {
		int count = 4;

		if (x - 1 >= 0 && grid[x - 1][y] == 1)
			count--;

		if (y - 1 >= 0 && grid[x][y - 1] == 1)
			count--;

		if (x + 1 < grid.length && grid[x + 1][y] == 1)
			count--;

		if (y + 1 < grid[0].length && grid[x][y + 1] == 1)
			count--;
		return count;
	}

}
