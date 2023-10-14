package Oct2023Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0049GroupAnagrams {

	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
		System.out.println(groupAnagrams(new String[] { "" }));
		System.out.println(groupAnagrams(new String[] { "a" }));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			String currString = strs[i];
			String sortedString = getSortedString(currString);
			if (!map.containsKey(sortedString)) {
				map.put(sortedString, new ArrayList<String>());
			}
			map.get(sortedString).add(currString);
		}
		List<List<String>> output = new ArrayList<List<String>>();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			output.add(entry.getValue());
		}
		return output;
	}

	public static String getSortedString(String str) {
		char[] cArr = str.toCharArray();
		Arrays.sort(cArr);
		return new String(cArr);
	}
}
