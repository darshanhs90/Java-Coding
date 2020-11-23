package Nov2020Leetcode;

public class _1351CountNegativeNumbersInASortedMatrix {
	public static void main(String[] args) {
		System.out.println(countNegatives(new int[][] { new int[] { 4, 3, 2, -1 }, new int[] { 3, 2, 1, -1 },
				new int[] { 1, 1, -1, -2 }, new int[] { -1, -1, -2, -3 } }));

		System.out.println(countNegatives(new int[][] { new int[] { 3, 2 }, new int[] { 1, 0 } }));
		System.out.println(countNegatives(new int[][] { new int[] { 1, -1 }, new int[] { -1, -1 } }));
		System.out.println(countNegatives(new int[][] { new int[] { -1 } }));

		System.out.println(countNegatives(new int[][] { new int[] { 4, 3, 3, 1, 1 }, new int[] { 1, 0, 0, -1, -1 },
				new int[] { -2, -2, -2, -2, -3 }, new int[] { -2, -2, -2, -3, -3 },
				new int[] { -3, -3, -3, -3, -3 } }));
	}

	public static int countNegatives(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int count = 0;
		int cols = grid[0].length - 1;
		for (int i = 0; i < grid.length; i++) {
			int leftIndex = 0;
			int rightIndex = cols;
			while (leftIndex < rightIndex) {
				int mid = (leftIndex + rightIndex) / 2;
				if (grid[i][mid] >= 0) {
					leftIndex = mid + 1;
				} else {
					rightIndex = mid - 1;
				}
			}

			if (rightIndex < 0)
				rightIndex = 0;
			else if (rightIndex <= cols && grid[i][rightIndex] >= 0) {
				rightIndex = rightIndex + 1;
			}

			if (rightIndex <= cols && grid[i][rightIndex] < 0) {
				count += grid[0].length - rightIndex;
			}
		}
		return count;
	}
}
