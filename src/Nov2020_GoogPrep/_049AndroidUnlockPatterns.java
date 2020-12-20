package Nov2020_GoogPrep;

public class _049AndroidUnlockPatterns {

	public static void main(String[] args) {
		System.out.println(numberOfPatterns(1, 1));
		System.out.println(numberOfPatterns(1, 2));
	}

	public static int numberOfPatterns(int m, int n) {
		boolean visited[] = new boolean[10];
		int[][] skip = new int[10][10];
		skip[1][3] = skip[3][1] = 2;
		skip[1][7] = skip[7][1] = 4;
		skip[3][9] = skip[9][3] = 6;
		skip[7][9] = skip[9][7] = 8;
		skip[2][8] = skip[8][2] = 5;
		skip[1][9] = skip[9][1] = 5;
		skip[3][7] = skip[7][3] = 5;
		skip[4][6] = skip[6][4] = 5;

		int count = 0;
		for (int i = m; i <= n; i++) {
			count += dfs(visited, skip, i - 1, 1) * 4;
			count += dfs(visited, skip, i - 1, 2) * 4;
			count += dfs(visited, skip, i - 1, 5);
		}
		return count;
	}

	public static int dfs(boolean[] visited, int[][] skip, int limit, int curr) {
		if (limit < 0)
			return 0;
		if (limit == 0)
			return 1;
		int count = 0;
		visited[curr] = true;
		for (int i = 1; i <= 9; i++) {
			if (!visited[i] && (skip[curr][i] == 0 || visited[skip[curr][i]])) {
				count += dfs(visited, skip, limit - 1, i);
			}
		}
		visited[curr] = false;
		return count;
	}
}
