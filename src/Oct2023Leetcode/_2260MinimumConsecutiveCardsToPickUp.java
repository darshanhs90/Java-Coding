package Oct2023Leetcode;

import java.util.HashMap;

public class _2260MinimumConsecutiveCardsToPickUp {
	public static void main(String[] args) {
		System.out.println(minimumCardPickup(new int[] { 3, 4, 2, 3, 4, 7 }));
		System.out.println(minimumCardPickup(new int[] { 1, 0, 5, 3 }));
	}

	public static int minimumCardPickup(int[] cards) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int minLen = cards.length + 1;
		for (int i = 0; i < cards.length; i++) {
			int currCard = cards[i];
			if (map.containsKey(currCard)) {
				minLen = Math.min(minLen, i - map.get(currCard) + 1);
			}
			map.put(currCard, i);
		}
		return minLen == cards.length + 1 ? -1 : minLen;
	}
}
