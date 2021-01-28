package Jan2021Leetcode;

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
		
	}
}
