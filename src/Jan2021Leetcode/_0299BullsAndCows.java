package Jan2021Leetcode;

import java.util.HashMap;

public class _0299BullsAndCows {

	public static void main(String[] args) {
		System.out.println(getHint("1807", "7810"));
		System.out.println(getHint("1123", "0111"));
		System.out.println(getHint("1", "0"));
		System.out.println(getHint("1", "1"));
	}

	public static String getHint(String secret, String guess) {
		int noOfBulls = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i))
				noOfBulls++;
			else {
				map.compute(secret.charAt(i), (k, v) -> v == null ? 1 : v + 1);
			}
		}

		int noOfCows = 0;
		for (int i = 0; i < guess.length(); i++) {
			char guessChar = guess.charAt(i);
			if (secret.charAt(i) != guessChar) {
				if (map.containsKey(guessChar) && map.get(guessChar) > 0) {
					map.put(guessChar, map.get(guessChar) - 1);
					noOfCows++;
				}
			}
		}
		return noOfBulls + "A" + noOfCows + "B";
	}
}
