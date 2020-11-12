package Leetcode2020Nov;

public class _1037ValidBoomerang {

	public static void main(String[] args) {
		System.out.println(isBoomerang(new int[][] { new int[] { 1, 1 }, new int[] { 2, 3 }, new int[] { 3, 2 }, }));
		System.out.println(isBoomerang(new int[][] { new int[] { 1, 1 }, new int[] { 2, 2 }, new int[] { 3, 3 }, }));
	}

	public static boolean isBoomerang(int[][] points) {
		int x1 = points[0][0];
		int y1 = points[0][1];
		int x2 = points[1][0];
		int y2 = points[1][1];
		int x3 = points[2][0];
		int y3 = points[2][1];

		return (y1 - y2) * (x1 - x3) != (y1 - y3) * (x1 - x2);
	}
}
