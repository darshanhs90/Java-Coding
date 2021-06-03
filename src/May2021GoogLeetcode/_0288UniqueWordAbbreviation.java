package May2021GoogLeetcode;

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
		
	}
}
