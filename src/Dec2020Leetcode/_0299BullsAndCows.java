package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0299BullsAndCows {

	public static void main(String[] args) {
		System.out.println(getHint("1807", "7810"));
		System.out.println(getHint("1123", "0111"));
		System.out.println(getHint("1", "0"));
		System.out.println(getHint("1", "1"));
	}

	public static String getHint(String secret, String guess) {
		int noOfBulls = 0, noOfCows = 0;
		HashMap<Character, List<Integer>> guessMap = new HashMap<Character, List<Integer>>();
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				noOfBulls++;
				continue;
			}
			char c = guess.charAt(i);
			if (guessMap.containsKey(c)) {
				guessMap.get(c).add(i);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				guessMap.put(c, list);
			}
		}
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				continue;
			}
			char c = secret.charAt(i);
			if (guessMap.containsKey(c) && guessMap.get(c).size() > 0) {
				guessMap.get(c).remove(0);
				noOfCows++;
			}
		}
		return noOfBulls + "A" + noOfCows + "B";
	}
}
