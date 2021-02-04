package Jan2021Leetcode;

import java.util.HashMap;

public class _0780ReachingPoints {
	public static void main(String[] args) {
		System.out.println(reachingPoints(1, 1, 3, 5));
		System.out.println(reachingPoints(1, 1, 2, 2));
	}

	public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		return dfs((long) sx, (long) sy, (long) tx, (long) ty, map);
	}

	public static boolean dfs(long sx, long sy, long tx, long ty, HashMap<String, Boolean> map) {
		if (sx > tx || sy > ty) {
			return false;
		}

		if (tx == sx && ty == sy)
			return true;

		if (map.containsKey(sx + "/" + sy))
			return map.get(sx + "/" + sy);

		boolean val = dfs(sx + sy, sy, tx, ty, map) || dfs(sx, sx + sy, tx, ty, map);
		map.put(sx + "/" + sy, val);
		return val;
	}

}
