package Feb2021Leetcode;

import java.util.HashMap;

public class _0149MaxPointsOnALine {
	public static void main(String[] args) {
		System.out.println(maxPoints(new int[][] { new int[] { 1, 1 }, new int[] { 2, 2 }, new int[] { 3, 3 } }));

		System.out.println(maxPoints(new int[][] { new int[] { 1, 1 }, new int[] { 3, 2 }, new int[] { 5, 3 },
				new int[] { 4, 1 }, new int[] { 2, 3 }, new int[] { 1, 4 } }));

	}

	public static int maxPoints(int[][] points) {
		if (points == null)
			return 0;
		if (points.length < 2)
			return points.length;

		int outMax = 0;
		for (int i = 0; i < points.length; i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int duplicates = 0;
			int max = 0;
			for (int j = i + 1; j < points.length; j++) {
				int xDiff = points[j][0] - points[i][0];
				int yDiff = points[j][1] - points[i][1];

				if (xDiff == 0 && yDiff == 0) {
					duplicates++;
					continue;
				}

				int gcdVal = gcd(xDiff, yDiff);
				int xVal = xDiff / gcdVal;
				int yVal = yDiff / gcdVal;

				map.compute(xVal + "/" + yVal, (k, v) -> v == null ? 1 : v + 1);

				max = Math.max(max, map.get(xVal + "/" + yVal));
			}
			outMax = Math.max(outMax, max + duplicates + 1);
		}
		return outMax;
	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}
