package Oct2023Leetcode;

import java.util.HashMap;

public class _1189MaximumNumberOfBalloons {
	public static void main(String[] args) {
		System.out.println(maxNumberOfBalloons("nlaebolko"));
		System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
		System.out.println(maxNumberOfBalloons("leetcode"));
		System.out.println(maxNumberOfBalloons("balloon"));
	}

	public static int maxNumberOfBalloons(String text) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String str = "balloon";
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			map.compute(c, (k, v) -> v == null ? 1 : v + 1);
		}
		int count = 0;
		while (true) {
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (map.containsKey(c) && map.get(c) > 0) {
					map.put(c, map.get(c) - 1);
				} else {
					return count;
				}
			}
			count++;
		}
	}
}
