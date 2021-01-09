package Dec2020Leetcode;

import java.util.HashSet;

public class _0771JewelsAndStones {
	public static void main(String[] args) {
		System.out.println(numJewelsInStones("aA", "aAAbbbb"));
		System.out.println(numJewelsInStones("z", "ZZ"));
	}

	public static int numJewelsInStones(String jewels, String stones) {
		int count = 0;
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < jewels.length(); i++) {
			set.add(jewels.charAt(i));
		}

		for (int i = 0; i < stones.length(); i++) {
			if (set.contains(stones.charAt(i)))
				count++;
		}
		return count;
	}
}
