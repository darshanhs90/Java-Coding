package Nov2020Leetcode;

public class _0463IslandPerimeter {

	public static void main(String[] args) {
		System.out.println(islandPerimeter(new int[][] { new int[] { 0, 1, 0, 0 }, new int[] { 1, 1, 1, 0 },
				new int[] { 0, 1, 0, 0 }, new int[] { 1, 1, 0, 0 }, }));

		System.out.println(islandPerimeter(new int[][] { new int[] { 1 } }));
		System.out.println(islandPerimeter(new int[][] { new int[] { 1, 0 } }));
	}

	public static int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				perimeter += getPerimeter(grid, i, j);
			}
		}
		return perimeter;
	}

	public static int getPerimeter(int[][] grid, int x, int y) {
		if (grid[x][y] == 0)
			return 0;
		int perimeter = 4;
		int rows = grid.length - 1;
		int cols = grid[0].length - 1;
		if (x - 1 >= 0 && grid[x - 1][y] == 1)
			perimeter--;

		if (y - 1 >= 0 && grid[x][y - 1] == 1)
			perimeter--;

		if (x + 1 <= rows && grid[x + 1][y] == 1)
			perimeter--;

		if (y + 1 <= cols && grid[x][y + 1] == 1)
			perimeter--;
		return perimeter;
	}
}
