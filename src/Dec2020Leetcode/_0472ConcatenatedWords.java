package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _0472ConcatenatedWords {

	public static void main(String[] args) {
		System.out.println(findAllConcatenatedWordsInADict(new String[] { "cat", "cats", "catsdogcats", "dog",
				"dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" }));
		System.out.println(findAllConcatenatedWordsInADict(new String[] { "cat", "dog", "catdog" }));
	}

	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
		HashSet<String> set = new HashSet<String>();
		for (String str : words) {
			set.add(str);
		}

		List<String> output = new ArrayList<String>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : words) {
			List<String> lst = new ArrayList<String>();
			if (wordBreak(0, str, lst, set, map)) {
				if (map.containsKey(str) && map.get(str).size() > 1)
					output.add(str);
			}
		}
		return output;
	}

	public static boolean wordBreak(int index, String str, List<String> list, HashSet<String> set,
			HashMap<String, List<String>> map) {
		if (index == str.length()) {
			map.put(str, list);
			return true;
		}

		for (int i = index; i < str.length(); i++) {
			String strNew = str.substring(index, i + 1);
			String restString = str.substring(i + 1);
			if (map.containsKey(strNew) && map.containsKey(restString) && map.get(strNew) != null
					&& map.get(restString) != null) {
				list.addAll(map.get(strNew));
				list.addAll(map.get(restString));
				map.put(str, list);
				return true;
			}

			if (map.containsKey(restString) && map.get(restString) == null)
				continue;

			list.add(strNew);

			if (set.contains(strNew)) {
				boolean val = wordBreak(i + 1, str, list, set, map);
				if (val)
					return true;
				else {
					map.put(restString, null);
				}
			} else {
				map.put(strNew, null);
			}
			list.remove(list.size() - 1);
		}
		return false;
	}

}
