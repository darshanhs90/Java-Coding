package Nov2020_GoogPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _075BullsAndCows {

	public static void main(String[] args) {
		System.out.println(getHint("1807", "7810"));
		System.out.println(getHint("1123", "0111"));
		System.out.println(getHint("1", "0"));
		System.out.println(getHint("1", "1"));
	}

	public static String getHint(String secret, String guess) {
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i <= 9; i++) {
			map.put(i, new ArrayList<Integer>());
		}
		int noOfBulls = 0, noOfCows = 0;

		for (int i = 0; i < secret.length(); i++) {
			char c1 = secret.charAt(i);
			char c2 = guess.charAt(i);
			if (c1 == c2) {
				noOfBulls++;
			} else {
				int val = c1 - '0';
				map.get(val).add(i);
			}
		}

		for (int i = 0; i < secret.length(); i++) {
			char c1 = secret.charAt(i);
			char c2 = guess.charAt(i);
			if (c1 != c2) {
				int val = c2 - '0';
				if (map.get(val).size() > 0) {
					map.get(val).remove(0);
					noOfCows++;
				}
			}
		}

		return noOfBulls + "A" + noOfCows + "B";
	}
}
