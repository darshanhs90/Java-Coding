package June2021GoogLeetcode;

import java.util.HashMap;

public class _0149MaxPointsOnALine {
	public static void main(String[] args) {
		System.out.println(maxPoints(new int[][] { new int[] { 1, 1 }, new int[] { 2, 2 }, new int[] { 3, 3 }, }));

		System.out.println(maxPoints(new int[][] { new int[] { 1, 1 }, new int[] { 3, 2 }, new int[] { 5, 3 },
				new int[] { 4, 1 }, new int[] { 2, 3 }, new int[] { 1, 4 }, }));

	}

	public static int maxPoints(int[][] points) {
		int max = 0;
		int overLaps = 0;

		for (int i = 0; i < points.length; i++) {
			int x1 = points[i][0];
			int y1 = points[i][1];
			HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer, Integer>>();
			overLaps = 0;
			int localMax = 0;
			for (int j = i + 1; j < points.length; j++) {
				int x2 = points[j][0];
				int y2 = points[j][1];

				int diffX = x2 - x1;
				int diffY = y2 - y1;

				if (diffX == 0 && diffY == 0) {
					overLaps++;
					continue;
				}

				int gcd = gcd(diffX, diffY);
				if (gcd != 0) {
					diffX = diffX / gcd;
					diffY = diffY / gcd;
				}

				if (!map.containsKey(diffX)) {
					map.put(diffX, new HashMap<Integer, Integer>());
				}

				if (!map.get(diffX).containsKey(diffY)) {
					map.get(diffX).put(diffY, 0);
				}

				map.get(diffX).compute(diffY, (k, v) -> v == null ? 1 : v + 1);
				localMax = Math.max(localMax, map.get(diffX).get(diffY));
			}

			max = Math.max(max, localMax + overLaps + 1);
		}
		return max;
	}

	public static int gcd(int x, int y) {
		if (y == 0)
			return x;
		return gcd(y, x % y);
	}

}
