package Nov2020_GfG;

public class _011XTotalShapes {

	public static void main(String[] args) {
		System.out.println(Shape(new String[] { "OOOOXXO", "OXOXOOX", "XXXXOXO", "OXXXOOO" }, 4, 7));
		System.out.println(
				Shape(new String[] { "XXO", "OOX", "OXO", "OOO", "XOX", "XOX", "OXO", "XXO", "XXX", "OOO" }, 10, 3));

	}

	public static int Shape(String[] arr, int n, int m) {
		if (arr == null || arr.length == 0)
			return 0;
		int count = 0;

		char[][] cArr = new char[arr.length][arr[0].length()];
		for (int i = 0; i < cArr.length; i++) {
			cArr[i] = arr[i].toCharArray();
		}
		for (int i = 0; i < cArr.length; i++) {
			for (int j = 0; j < cArr[0].length; j++) {
				if (cArr[i][j] == 'X') {
					count++;
					dfs(i, j, cArr);
				}
			}
		}
		return count;
	}

	public static void dfs(int x, int y, char[][] cArr) {
		if (x < 0 || y < 0 || x > cArr.length - 1 || y > cArr[0].length - 1 || cArr[x][y] != 'X')
			return;
		cArr[x][y] = '*';
		dfs(x - 1, y, cArr);
		dfs(x + 1, y, cArr);
		dfs(x, y - 1, cArr);
		dfs(x, y + 1, cArr);
	}
}
