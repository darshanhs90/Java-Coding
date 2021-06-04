package June2021GoogLeetcode;

import java.util.HashMap;

public class _0299BullsAndCows {

	public static void main(String[] args) {
		System.out.println(getHint("1807", "7810"));
		System.out.println(getHint("1123", "0111"));
		System.out.println(getHint("1", "0"));
		System.out.println(getHint("1", "1"));
	}

	public static String getHint(String secret, String guess) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int noOfBulls = 0, noOfCows = 0;
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				noOfBulls++;
			} else {
				map.compute(secret.charAt(i), (k, v) -> v == null ? 1 : v + 1);
			}
		}

		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) != guess.charAt(i) && map.containsKey(guess.charAt(i))
					&& map.get(guess.charAt(i)) > 0) {
				noOfCows++;
				map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
			}
		}

		return noOfBulls + "A" + noOfCows + "B";
	}
}
