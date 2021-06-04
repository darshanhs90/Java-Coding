package June2021GoogLeetcode;

import java.util.HashMap;

public class _0288UniqueWordAbbreviation {

	public static void main(String[] args) {
		ValidWordAbbr validWordAbbr = new ValidWordAbbr(new String[] { "deer", "door", "cake", "card" });
		System.out.println(validWordAbbr.isUnique("dear")); // return false, dictionary word "deer" and word "dear" have
															// the same
		// abbreviation
		// "d2r" but are not the same.
		System.out.println(validWordAbbr.isUnique("cart")); // return true, no words in the dictionary have the
															// abbreviation "c2t".
		System.out.println(validWordAbbr.isUnique("cane")); // return false, dictionary word "cake" and word "cane" have
															// the same
		// abbreviation
		// "c2e" but are not the same.
		System.out.println(validWordAbbr.isUnique("make")); // return true, no words in the dictionary have the
															// abbreviation "m2e".
		System.out.println(validWordAbbr.isUnique("cake")); // return true, because "cake" is already in the dictionary
															// and no other word in
		// the dictionary has "c2e" abbreviation.
	}

	static class ValidWordAbbr {
		HashMap<String, String> map;

		public ValidWordAbbr(String[] dictionary) {
			map = new HashMap<String, String>();

			for (String word : dictionary) {
				String abbr = getAbbreviation(word);

				if (!map.containsKey(abbr)) {
					map.put(abbr, word);
				} else if (!map.get(abbr).equals(word)) {
					map.put(abbr, "");
				}
			}

		}

		public boolean isUnique(String word) {
			String abbr = getAbbreviation(word);
			if (!map.containsKey(abbr))
				return true;
			if (map.get(abbr).equals("") || !map.get(abbr).equals(word))
				return false;
			return true;
		}

		public String getAbbreviation(String word) {
			return word.charAt(0) + "" + (word.length() - 2) + word.charAt(word.length() - 1);

		}
	}
}
