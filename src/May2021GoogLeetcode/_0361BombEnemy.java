package May2021GoogLeetcode;

public class _0361BombEnemy {

	public static void main(String[] args) {
		System.out.println(maxKilledEnemies(new char[][] { new char[] { '0', 'E', '0', '0' },
				new char[] { 'E', '0', 'W', 'E' }, new char[] { '0', 'E', '0', '0' } }));

		System.out.println(maxKilledEnemies(new char[][] { new char[] { 'W', 'W', 'W' }, new char[] { '0', '0', '0' },
				new char[] { 'E', 'E', 'E' } }));

	}

	public static int maxKilledEnemies(char[][] grid) {
		int[][] sum = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 'E') {
					populateSum(i, j, grid, sum);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < sum[0].length; j++) {
				if (grid[i][j] == '0') {
					max = Math.max(max, sum[i][j]);
				}
			}
		}
		return max;
	}

	public static void populateSum(int x, int y, char[][] grid, int[][] sum) {
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		for (int i = 0; i < dirs.length; i++) {
			int currX = x + dirs[i][0];
			int currY = y + dirs[i][1];

			while (currX >= 0 && currY >= 0 && currX < grid.length && currY < grid[0].length
					&& grid[currX][currY] != 'W') {
				sum[currX][currY] += 1;
				currX += dirs[i][0];
				currY += dirs[i][1];
			}
		}
	}
}
