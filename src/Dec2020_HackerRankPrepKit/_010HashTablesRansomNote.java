package Dec2020_HackerRankPrepKit;

import java.util.HashMap;

public class _010HashTablesRansomNote {

	public static void main(String[] args) {
		checkMagazine(new String[] { "give", "me", "one", "grand", "today", "night" },
				new String[] { "give", "one", "grand", "today" });
		checkMagazine(new String[] { "give", "me", "one", "grand", "today", "night" },
				new String[] { "Give", "one", "grand", "today" });
		checkMagazine(new String[] { "two", "times", "three", "is", "not", "four" },
				new String[] { "two", "times", "two", "is", "four" });
	}

	static void checkMagazine(String[] magazine, String[] note) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < magazine.length; i++) {
			if (map.containsKey(magazine[i])) {
				map.put(magazine[i], map.get(magazine[i]) + 1);
			} else {
				map.put(magazine[i], 1);
			}
		}

		for (int i = 0; i < note.length; i++) {
			if (!map.containsKey(note[i])) {
				System.out.println("No");
				return;
			} else {
				if (map.get(note[i]) == 1) {
					map.remove(note[i]);
				} else {
					map.put(note[i], map.get(note[i]) - 1);
				}
			}
		}
		System.out.println("Yes");
	}
}
