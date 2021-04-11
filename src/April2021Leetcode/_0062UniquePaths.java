package April2021Leetcode;

public class _0062UniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 7));
		System.out.println(uniquePaths(3, 2));
		System.out.println(uniquePaths(7, 3));
		System.out.println(uniquePaths(3, 3));
	}

	public static int uniquePaths(int m, int n) {
		int[][] arr = new int[m][n];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = 1;
		}
		for (int i = 0; i < arr[0].length; i++) {
			arr[0][i] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}
		}
		return arr[m - 1][n - 1];
	}
}
