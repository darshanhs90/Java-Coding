package Leetcode2020Nov;

public class _0598RangeAdditionII {

	public static void main(String[] args) {
		System.out.println(maxCount(3, 3, new int[][] { new int[] { 2, 2 }, new int[] { 3, 3 } }));
		System.out.println(maxCount(3, 3,
				new int[][] { new int[] { 2, 2 }, new int[] { 3, 3 }, new int[] { 3, 3 }, new int[] { 3, 3 },
						new int[] { 2, 2 }, new int[] { 3, 3 }, new int[] { 3, 3 }, new int[] { 3, 3 },
						new int[] { 2, 2 }, new int[] { 3, 3 }, new int[] { 3, 3 }, new int[] { 3, 3 } }));
		System.out.println(maxCount(3, 3, new int[][] {}));
	}

	public static int maxCount(int m, int n, int[][] ops) {
		int xIndex = m;
		int yIndex = n;
		for (int i = 0; i < ops.length; i++) {
			int rows = ops[i][0];
			int cols = ops[i][1];
			if (rows < xIndex && rows != 0) {
				xIndex = rows;
			}
			if (cols < yIndex && cols != 0) {
				yIndex = cols;
			}
		}
		return xIndex * yIndex;
	}
}
