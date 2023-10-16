package Oct2023Leetcode;

import java.util.HashSet;

public class _1496PathCrossing {
	public static void main(String[] args) {
		System.out.println(isPathCrossing("NES"));
		System.out.println(isPathCrossing("NESWW"));
	}

	public static boolean isPathCrossing(String path) {
		HashSet<String> set = new HashSet<String>();
		int currX = 0, currY = 0;
		set.add("0/0");
		for (int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);
			if (c == 'N') {
				currY += 1;
			} else if (c == 'E') {
				currX += 1;
			} else if (c == 'W') {
				currX -= 1;
			} else {
				currY -= 1;
			}
			String str = currX + "/" + currY;
			if (set.contains(str)) {
				return true;
			}
			set.add(str);
		}
		return false;
	}
}
