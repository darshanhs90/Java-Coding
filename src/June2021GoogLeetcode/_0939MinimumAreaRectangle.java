package June2021GoogLeetcode;

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
		for (int[] point : points) {
			int x = point[0];
			int y = point[1];

			if (!map.containsKey(x)) {
				map.put(x, new HashSet<Integer>());
			}
			map.get(x).add(y);
		}

		int minArea = Integer.MAX_VALUE;
		for (int i = 0; i < points.length; i++) {
			int baseX = points[i][0];
			int baseY = points[i][1];
			for (int j = i + 1; j < points.length; j++) {
				int currX = points[j][0];
				int currY = points[j][1];

				if (baseX == currX || baseY == currY)
					continue;

				if (map.get(baseX).contains(currY) && map.get(currX).contains(baseY)) {
					minArea = Math.min(minArea, Math.abs(baseX - currX) * Math.abs(baseY - currY));
				}
			}
		}
		return minArea == Integer.MAX_VALUE ? 0 : minArea;
	}
}
