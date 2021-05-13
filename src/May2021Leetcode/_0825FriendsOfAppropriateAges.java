package May2021Leetcode;

import java.util.HashMap;

public class _0825FriendsOfAppropriateAges {

	public static void main(String[] args) {
		System.out.println(numFriendRequests(new int[] { 16, 16 }));
		System.out.println(numFriendRequests(new int[] { 16, 17, 18 }));
		System.out.println(numFriendRequests(new int[] { 20, 30, 100, 110, 120 }));
	}

	public static int numFriendRequests(int[] ages) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < ages.length; i++) {
			map.compute(ages[i], (k, v) -> v == null ? 1 : v + 1);
		}
		int count = 0;
		for (int ageA = 120; ageA >= 1; ageA--) {
			for (int ageB = 120; ageB >= 1; ageB--) {
				if (map.containsKey(ageA) && map.containsKey(ageB)) {
					if (ageB <= 0.5 * ageA + 7)
						continue;
					if (ageB > ageA)
						continue;
					if (ageB > 100 && ageA < 100)
						continue;

					int val1 = map.get(ageA);
					int val2 = map.get(ageB);

					if (ageA == ageB) {
						count += (val1 * (val1 - 1));
					} else {
						count += val1 * val2;
					}
				}
			}
		}
		return count;
	}

}
