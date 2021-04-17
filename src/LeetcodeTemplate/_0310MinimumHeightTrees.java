package LeetcodeTemplate;

public class _0310MinimumHeightTrees {

	public static void main(String[] args) {
		System.out.println(
				findMinHeightTrees(4, new int[][] { new int[] { 1, 0 }, new int[] { 1, 2 }, new int[] { 1, 3 } }));
		System.out.println(findMinHeightTrees(6, new int[][] { new int[] { 3, 0 }, new int[] { 3, 1 },
				new int[] { 3, 2 }, new int[] { 3, 4 }, new int[] { 5, 4 } }));
		System.out.println(findMinHeightTrees(1, new int[][] {}));
		System.out.println(findMinHeightTrees(2, new int[][] { new int[] { 0, 1 } }));
	}

}
