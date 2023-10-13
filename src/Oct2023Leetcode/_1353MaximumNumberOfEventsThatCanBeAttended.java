package Oct2023Leetcode;

public class _1353MaximumNumberOfEventsThatCanBeAttended {

	public static void main(String[] args) {
		System.out.println(maxEvents(
				new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 }, new int[] { 1, 2 } }));

		System.out.println(maxEvents(new int[][] { new int[] { 1, 4 }, new int[] { 4, 4 }, new int[] { 2, 2 },
				new int[] { 3, 4 }, new int[] { 1, 1 } }));

		System.out.println(maxEvents(new int[][] { new int[] { 1, 100000 } }));

		System.out.println(maxEvents(new int[][] { new int[] { 1, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 },
				new int[] { 1, 4 }, new int[] { 1, 5 }, new int[] { 1, 6 }, new int[] { 1, 7 } }));
	}

	public static int maxEvents(int[][] events) {

	}
}
