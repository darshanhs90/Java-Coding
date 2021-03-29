package Mar2021Leetcode;

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
		List<List<String>> output = new ArrayList<List<String>>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			String str = strs[i];
			char[] cArr = str.toCharArray();
			Arrays.sort(cArr);

			String sortedString = new String(cArr);

			if (!map.containsKey(sortedString)) {
				map.put(sortedString, new ArrayList<String>());
			}

			map.get(sortedString).add(str);
		}

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			output.add(entry.getValue());
		}
		return output;
	}
}
