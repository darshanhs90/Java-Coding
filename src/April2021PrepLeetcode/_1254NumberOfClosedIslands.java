package April2021PrepLeetcode;

public class _1254NumberOfClosedIslands {
	public static void main(String[] args) {
		System.out.println(closedIsland(new int[][] { new int[] { 1, 1, 1, 1, 1, 1, 1, 0 },
				new int[] { 1, 0, 0, 0, 0, 1, 1, 0 }, new int[] { 1, 0, 1, 0, 1, 1, 1, 0 },
				new int[] { 1, 0, 0, 0, 0, 1, 0, 1 }, new int[] { 1, 1, 1, 1, 1, 1, 1, 0 } }));

		System.out.println(closedIsland(
				new int[][] { new int[] { 0, 0, 1, 0, 0 }, new int[] { 0, 1, 0, 1, 0 }, new int[] { 0, 1, 1, 1, 0 } }));

		System.out.println(closedIsland(new int[][] { new int[] { 1, 1, 1, 1, 1, 1, 1 },
				new int[] { 1, 0, 0, 0, 0, 0, 1 }, new int[] { 1, 0, 1, 1, 1, 0, 1 }, new int[] { 1, 0, 1, 0, 1, 0, 1 },
				new int[] { 1, 0, 1, 1, 1, 0, 1 }, new int[] { 1, 0, 0, 0, 0, 0, 1 },
				new int[] { 1, 1, 1, 1, 1, 1, 1 } }));
	}

	public static int closedIsland(int[][] grid) {
		
	}

}
