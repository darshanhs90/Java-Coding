package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0424LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		System.out.println(characterReplacement("ABAB", 2));
		System.out.println(characterReplacement("AABABBA", 1));
		System.out.println(characterReplacement("BBAAA", 2));
		System.out.println(characterReplacement("BAAAB", 2));
		System.out.println(characterReplacement("ABAA", 0));
	}

	public static int characterReplacement(String s, int k) {
		HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
		Character prev = null;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c) && prev != c) {
				map.get(c).add(i);
			} else if (!map.containsKey(c)) {
				List<Integer> lst = new ArrayList<Integer>();
				lst.add(i);
				map.put(c, lst);
			}
			prev = c;
		}
		int max = 0;
		for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
			char c = entry.getKey();
			List<Integer> lst = entry.getValue();

			for (int i = 0; i < lst.size(); i++) {
				max = Math.max(max, getMaxLength(lst.get(i), c, k, s));
			}
		}

		return max;
	}

	public static int getMaxLength(int index, char c, int k, String s) {
		int count = 0;
		while (index < s.length()) {
			
			if (s.charAt(index) != c) {
				k--;
			}
			
			if(k<0)
				return count;
			index++;
			count++;
		}
		return count;
	}

}
