package FacebookPrep;

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
		int ans = 0;
		for (int ageA = 0; ageA <= 120; ageA++) {
			if (!map.containsKey(ageA))
				continue;
			int countA = map.get(ageA);
			for (int ageB = 0; ageB <= 120; ageB++) {
				if (!map.containsKey(ageB))
					continue;
				int countB = map.get(ageB);
				if (ageA * 0.5 + 7 >= ageB)
					continue;
				if (ageA < ageB)
					continue;
				if (ageA < 100 && 100 < ageB)
					continue;

				if (ageA == ageB) {
					ans += countA * (countA - 1);
				} else {
					ans += countA * countB;
				}
			}
		}
		return ans;
	}

}
