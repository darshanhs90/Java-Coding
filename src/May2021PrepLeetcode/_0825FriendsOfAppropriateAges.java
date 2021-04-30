package May2021PrepLeetcode;

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
		for (int ageA = 1; ageA <= 120; ageA++) {
			for (int ageB = 1; ageB <= 120; ageB++) {
				if (ageB <= 0.5 * ageA + 7)
					continue;
				if (ageB > ageA)
					continue;
				if (ageB > 100 && ageA < 100)
					continue;

				if (map.containsKey(ageA) && map.containsKey(ageB)) {
					count += map.get(ageA) * map.get(ageB);
					if (ageA == ageB)
						count -= map.get(ageA);
				}
			}
		}
		return count;
	}

}
