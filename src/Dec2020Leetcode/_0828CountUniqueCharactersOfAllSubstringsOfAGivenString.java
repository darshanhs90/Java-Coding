package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0828CountUniqueCharactersOfAllSubstringsOfAGivenString {

	public static void main(String[] args) {
		System.out.println(uniqueLetterString("ABC"));
		System.out.println(uniqueLetterString("ABA"));
		System.out.println(uniqueLetterString("LEETCODE"));
	}

	public static int uniqueLetterString(String s) {
		HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c))
				map.get(c).add(i);
			else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(c, list);
			}
		}

		long result = 0;
		for (List<Integer> lst : map.values()) {
			for (int i = 0; i < lst.size(); i++) {
				int prev = i == 0 ? -1 : lst.get(i - 1);
				int next = i == lst.size() - 1 ? s.length() : lst.get(i + 1);
				int curr = lst.get(i);
				result += (curr - prev) * (next - curr);
			}
		}
		return (int) result % 1_000_000_007;
	}

}
