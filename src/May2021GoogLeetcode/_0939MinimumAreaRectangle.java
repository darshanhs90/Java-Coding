package May2021GoogLeetcode;

import java.util.HashMap;
import java.util.HashSet;

public class _0939MinimumAreaRectangle {
	public static void main(String[] args) {
		System.out.println(minAreaRect(new int[][] { new int[] { 1, 1 }, new int[] { 1, 3 }, new int[] { 3, 1 },
				new int[] { 3, 3 }, new int[] { 2, 2 } }));

		System.out.println(minAreaRect(new int[][] { new int[] { 1, 1 }, new int[] { 1, 3 }, new int[] { 3, 1 },
				new int[] { 3, 3 }, new int[] { 4, 1 }, new int[] { 4, 3 } }));

	}

	public static int minAreaRect(int[][] points) {
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i < points.length; i++) {
			int x = points[i][0];
			int y = points[i][1];

			if (!map.containsKey(x)) {
				map.put(x, new HashSet<Integer>());
			}

			map.get(x).add(y);
		}

		int minArea = Integer.MAX_VALUE;

		for (int i = 0; i < points.length; i++) {
			int x1 = points[i][0];
			int y1 = points[i][1];
			for (int j = i + 1; j < points.length; j++) {
				int x2 = points[j][0];
				int y2 = points[j][1];

				if (x1 == x2 || y1 == y2)
					continue;

				if (map.get(x1).contains(y2) && map.get(x2).contains(y1)) {
					minArea = Math.min(minArea, Math.abs(x1 - x2) * Math.abs(y1 - y2));
				}
			}
		}
		return minArea == Integer.MAX_VALUE ? 0 : minArea;
	}
}
