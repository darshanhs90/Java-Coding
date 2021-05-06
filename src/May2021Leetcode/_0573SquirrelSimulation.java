package May2021Leetcode;

public class _0573SquirrelSimulation {
	public static void main(String[] args) {
		System.out.println(minDistance(5, 7, new int[] { 2, 2 }, new int[] { 4, 4 },
				new int[][] { new int[] { 3, 0 }, new int[] { 2, 5 } }));

		System.out
				.println(minDistance(1, 3, new int[] { 0, 1 }, new int[] { 0, 0 }, new int[][] { new int[] { 0, 2 } }));
	}

	public static int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
		int totalDistance = 0;
		int maxSaving = Integer.MIN_VALUE;
		for (int[] nut : nuts) {
			totalDistance += (distance(nut, tree) * 2);
			maxSaving = Math.max(maxSaving, distance(nut, tree) - distance(nut, squirrel));
		}
		return totalDistance - maxSaving;
	}

	public static int distance(int[] tree, int[] nut) {
		return Math.abs(tree[0] - nut[0]) + Math.abs(tree[1] - nut[1]);
	}
}
