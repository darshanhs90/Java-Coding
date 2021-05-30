package May2021GoogLeetcode;

import java.util.HashMap;

public class _0149MaxPointsOnALine {
	public static void main(String[] args) {
		System.out.println(maxPoints(new int[][] { new int[] { 1, 1 }, new int[] { 2, 2 }, new int[] { 3, 3 }, }));

		System.out.println(maxPoints(new int[][] { new int[] { 1, 1 }, new int[] { 3, 2 }, new int[] { 5, 3 },
				new int[] { 4, 1 }, new int[] { 2, 3 }, new int[] { 1, 4 }, }));

	}

	public static int maxPoints(int[][] points) {
		if (points == null)
			return 0;
		if (points.length <= 2)
			return points.length;
		int res = 0;
		for (int i = 0; i < points.length; i++) {
			int x1 = points[i][0];
			int y1 = points[i][1];
			int overLaps = 0;
			int localMax = 0;
			HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer, Integer>>();
			for (int j = i + 1; j < points.length; j++) {
				int x2 = points[j][0];
				int y2 = points[j][1];
				int deltaX = x2 - x1;
				int deltaY = y2 - y1;

				if (deltaX == 0 && deltaY == 0) {
					overLaps += 1;
					continue;
				}

				int gcdVal = gcd(deltaX, deltaY);
				if (gcdVal != 0) {
					deltaX = deltaX / gcdVal;
					deltaY = deltaY / gcdVal;
				}

				if (!map.containsKey(deltaX)) {
					map.put(deltaX, new HashMap<Integer, Integer>());
				}

				if (!map.get(deltaX).containsKey(deltaY)) {
					map.get(deltaX).put(deltaY, 0);
				}
				map.get(deltaX).compute(deltaY, (k, v) -> v == null ? 1 : v + 1);
				localMax = Math.max(localMax, map.get(deltaX).get(deltaY));
			}
			res = Math.max(res, localMax + overLaps + 1);
		}
		return res;
	}

	public static int gcd(int x, int y) {
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}

}
