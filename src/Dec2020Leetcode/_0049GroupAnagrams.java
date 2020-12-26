package Dec2020Leetcode;

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
		if (strs.length == 0)
			return output;

		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] charArr = str.toCharArray();
			Arrays.sort(charArr);
			String sortedString = new String(charArr);

			if (map.containsKey(sortedString)) {
				map.get(sortedString).add(str);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(str);
				map.put(sortedString, list);
			}
		}
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			output.add(entry.getValue());
		}
		return output;
	}
}
