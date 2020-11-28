package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _008GroupAnagrams {

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
			char[] c = str.toCharArray();
			Arrays.sort(c);
			String sortedString = new String(c);
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
