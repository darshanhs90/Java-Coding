package April2021PrepLeetcode;

public class _0200NumberOfIslands {

	public static void main(String[] args) {
		System.out.println(numIslands(
				new char[][] { new char[] { '1', '1', '1', '1', '0' }, new char[] { '1', '1', '0', '1', '0' },
						new char[] { '1', '1', '0', '0', '0' }, new char[] { '0', '0', '0', '0', '0' } }));

		System.out.println(numIslands(
				new char[][] { new char[] { '1', '1', '0', '0', '0' }, new char[] { '1', '1', '0', '0', '0' },
						new char[] { '0', '0', '1', '0', '0' }, new char[] { '0', '0', '0', '1', '1' } }));
	}

	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					dfs(i, j, grid);
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(int x, int y, char[][] grid) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != '1')
			return;
		grid[x][y] = '0';
		dfs(x - 1, y, grid);
		dfs(x + 1, y, grid);
		dfs(x, y - 1, grid);
		dfs(x, y + 1, grid);
	}

}
