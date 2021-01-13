package Dec2020Leetcode;

import java.awt.Point;
import java.util.HashMap;

public class _0780ReachingPoints {
	public static void main(String[] args) {
		System.out.println(reachingPoints(1, 1, 3, 5));
	}

	public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
		HashMap<Point, Boolean> map = new HashMap<Point, Boolean>();
		reachingPoints(sx, sy, tx, ty, map);
		return map.get(new Point(sx, sy));
	}

	public static boolean reachingPoints(int sx, int sy, int tx, int ty, HashMap<Point, Boolean> map) {
		if (sx == tx && sy == ty) {
			map.put(new Point(sx, sy), true);
			return true;
		}

		if (map.containsKey(new Point(sx, sy)))
			return map.get(new Point(sx, sy));

		if (sx > tx || sy > ty) {
			map.put(new Point(sx, sy), false);
			return false;
		}

		boolean val = reachingPoints(sx + sy, sy, tx, ty, map) || reachingPoints(sx, sx + sy, tx, ty, map);
		map.put(new Point(sx, sy), val);
		return val;
	}

}
