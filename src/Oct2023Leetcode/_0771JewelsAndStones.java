package Oct2023Leetcode;

import java.util.HashSet;

public class _0771JewelsAndStones {
	public static void main(String[] args) {
		System.out.println(numJewelsInStones("aA", "aAAbbbb"));
		System.out.println(numJewelsInStones("z", "ZZ"));
	}

	public static int numJewelsInStones(String jewels, String stones) {
		HashSet<Character> jewelSet = new HashSet<Character>();
		for (int i = 0; i < jewels.length(); i++) {
			jewelSet.add(jewels.charAt(i));
		}
		int count = 0;
		for (int i = 0; i < stones.length(); i++) {
			if (jewelSet.contains(stones.charAt(i))) {
				count++;
			}
		}
		return count;
	}
}
