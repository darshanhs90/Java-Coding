package Dec2020Leetcode;

public class _0286WallsAndGates {

	public static void main(String[] args) {
		wallsAndGates(new int[][] { new int[] { Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE },
				new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1 },
				new int[] { Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1 },
				new int[] { 0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE }, });

	}

	public static void wallsAndGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0)
			return;
		boolean[][] visited = new boolean[rooms.length][rooms[0].length];
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					dfs(i, j, rooms, 0, visited, true);
				}
			}
		}
	}

	public static void dfs(int x, int y, int[][] rooms, int currDistance, boolean[][] visited, boolean isStart) {
		if (!isStart) {
			if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length || visited[x][y] || rooms[x][y] == -1
					|| rooms[x][y] == 0)
				return;
			if (currDistance > rooms[x][y])
				return;
			visited[x][y] = true;
			rooms[x][y] = currDistance;
			dfs(x - 1, y, rooms, currDistance + 1, visited, false);
			dfs(x + 1, y, rooms, currDistance + 1, visited, false);
			dfs(x, y - 1, rooms, currDistance + 1, visited, false);
			dfs(x, y + 1, rooms, currDistance + 1, visited, false);
			visited[x][y] = false;
		} else {
			visited[x][y] = true;
			dfs(x - 1, y, rooms, currDistance + 1, visited, false);
			dfs(x + 1, y, rooms, currDistance + 1, visited, false);
			dfs(x, y - 1, rooms, currDistance + 1, visited, false);
			dfs(x, y + 1, rooms, currDistance + 1, visited, false);
			visited[x][y] = false;
		}
	}

}
