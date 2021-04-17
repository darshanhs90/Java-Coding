package April2021PrepLeetcode;

import java.util.List;

public class _0797AllPathsFromSourceToTarget {
	public static void main(String[] args) {
		System.out.println(allPathsSourceTarget(
				new int[][] { new int[] { 1, 2 }, new int[] { 3 }, new int[] { 3 }, new int[] {} }));

		System.out.println(allPathsSourceTarget(new int[][] { new int[] { 4, 3, 1 }, new int[] { 3, 2, 4 },
				new int[] { 3 }, new int[] { 4 }, new int[] {} }));

		System.out.println(allPathsSourceTarget(new int[][] { new int[] { 1 }, new int[] {} }));

		System.out.println(allPathsSourceTarget(
				new int[][] { new int[] { 1, 2, 3 }, new int[] { 2 }, new int[] { 3 }, new int[] {} }));

		System.out.println(allPathsSourceTarget(
				new int[][] { new int[] { 1, 3 }, new int[] { 2 }, new int[] { 3 }, new int[] {} }));

	}

	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

	}

}
