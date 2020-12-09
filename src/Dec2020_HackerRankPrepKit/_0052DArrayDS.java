package Dec2020_HackerRankPrepKit;

public class _0052DArrayDS {

	public static void main(String[] args) {
		System.out.println(hourglassSum(new int[][] { new int[] { 1, 1, 1, 0, 0, 0 }, new int[] { 0, 1, 0, 0, 0, 0 },
				new int[] { 1, 1, 1, 0, 0, 0 }, new int[] { 0, 0, 2, 4, 4, 0 }, new int[] { 0, 0, 0, 2, 0, 0 },
				new int[] { 0, 0, 1, 2, 4, 0 } }));
	}

	static int hourglassSum(int[][] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				int sum = arr[i][j] + arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1] + arr[i + 1][j - 1]
						+ arr[i + 1][j + 1] + arr[i + 1][j];
				max = Math.max(sum, max);
			}
		}
		return max;
	}
}
