package Dec2020Leetcode;

public class _1232CheckIfItIsAStraightLine {
	public static void main(String[] args) {
		System.out.println(checkStraightLine(new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 },
				new int[] { 4, 5 }, new int[] { 5, 6 }, new int[] { 6, 7 } }));
		System.out.println(checkStraightLine(new int[][] { new int[] { 1, 1 }, new int[] { 2, 2 }, new int[] { 3, 4 },
				new int[] { 4, 5 }, new int[] { 5, 6 }, new int[] { 7, 7 } }));
		System.out.println(
				checkStraightLine(new int[][] { new int[] { 0, 0 }, new int[] { 0, 1 }, new int[] { 0, -1 } }));
		System.out
				.println(checkStraightLine(new int[][] { new int[] { 2, 4 }, new int[] { 2, 5 }, new int[] { 2, 8 } }));
	}

	public static boolean checkStraightLine(int[][] coordinates) {
		int x1 = coordinates[0][0];
		int y1 = coordinates[0][1];
		int x2 = coordinates[1][0];
		int y2 = coordinates[1][1];

		int dx = x2 - x1, dy = y2 - y1;
		for (int i = 0; i < coordinates.length; i++) {
			int xNew = coordinates[i][0];
			int yNew = coordinates[i][1];
			if (dx * (-yNew + y1) != dy * (-xNew + x1))
				return false;
		}
		return true;
	}
}
