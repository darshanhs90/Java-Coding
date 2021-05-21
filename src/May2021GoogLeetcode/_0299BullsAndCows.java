package May2021GoogLeetcode;

import java.util.HashMap;
import java.util.HashSet;

public class _0299BullsAndCows {

	public static void main(String[] args) {
		System.out.println(getHint("1807", "7810"));
		System.out.println(getHint("1123", "0111"));
		System.out.println(getHint("1", "0"));
		System.out.println(getHint("1", "1"));
	}

	public static String getHint(String secret, String guess) {
		int noOfBulls = 0, noOfCows = 0;
		HashMap<Character, HashSet<Integer>> map = new HashMap<Character, HashSet<Integer>>();
		for (int i = 0; i < secret.length(); i++) {
			char c1 = secret.charAt(i);
			char c2 = guess.charAt(i);
			if (c1 != c2) {
				if (!map.containsKey(c2)) {
					map.put(c2, new HashSet<Integer>());
				}

				map.get(c2).add(i);
			} else {
				noOfBulls++;
			}
		}

		for (int i = 0; i < secret.length(); i++) {
			char c1 = secret.charAt(i);
			char c2 = guess.charAt(i);
			if (c1 != c2) {
				if (map.containsKey(c1) && map.get(c1).size() > 0) {
					noOfCows++;
					map.get(c1).remove(map.get(c1).iterator().next());
				}
			}
		}
		return noOfBulls + "A" + noOfCows + "B";
	}
}
