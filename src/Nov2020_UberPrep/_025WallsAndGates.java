package Nov2020_UberPrep;

import java.util.Arrays;

public class _025WallsAndGates {

	public static void main(String[] args) {
		wallsAndGates(new int[][] { new int[] { Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE },
				new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1 },
				new int[] { Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1 },
				new int[] { 0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE },

		});

	}

	public static void wallsAndGates(int[][] rooms) {
		if (rooms.length == 0)
			return;
		boolean[][] visited = new boolean[rooms.length][rooms[0].length];
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					dfs(i - 1, j, rooms, visited, 1);
					dfs(i + 1, j, rooms, visited, 1);
					dfs(i, j - 1, rooms, visited, 1);
					dfs(i, j + 1, rooms, visited, 1);
				}
			}
		}

		for (int i = 0; i < rooms.length; i++) {
			System.out.println(Arrays.toString(rooms[i]));
		}

	}

	public static void dfs(int x, int y, int[][] rooms, boolean[][] visited, int currLength) {
		if (x < 0 || y < 0 || x > rooms.length - 1 || y > rooms[0].length - 1 || visited[x][y] || rooms[x][y] == 0
				|| rooms[x][y] == -1)
			return;
		if (rooms[x][y] < currLength)
			return;
		rooms[x][y] = currLength;
		visited[x][y] = true;
		dfs(x - 1, y, rooms, visited, currLength + 1);
		dfs(x + 1, y, rooms, visited, currLength + 1);
		dfs(x, y - 1, rooms, visited, currLength + 1);
		dfs(x, y + 1, rooms, visited, currLength + 1);
		visited[x][y] = false;
	}

}
