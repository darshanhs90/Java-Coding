package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _0249GroupShiftedStrings {

	public static void main(String[] args) {
		System.out.println(groupStrings(new String[] { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" }));
		System.out.println(groupStrings(new String[] { "a", "a" }));
	}

	public static List<List<String>> groupStrings(String[] strings) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < strings.length; i++) {
			map.compute(strings[i], (k, v) -> v == null ? 1 : v + 1);
		}
		HashSet<String> visited = new HashSet<String>();
		List<List<String>> output = new ArrayList<List<String>>();
		for (int i = 0; i < strings.length; i++) {
			String currString = strings[i];
			if (!visited.contains(currString)) {

				List<String> list = new ArrayList<String>();
				for (int len = 0; len < 26; len++) {
					char[] cArr = currString.toCharArray();
					for (int j = 0; j < cArr.length; j++) {
						cArr[j] += 1;
						if (cArr[j] > 'z')
							cArr[j] = 'a';
					}
					String newString = new String(cArr);
					if (map.containsKey(newString)) {
						visited.add(newString);
						int val = map.get(newString);
						for (int j = 0; j < val; j++) {
							list.add(newString);
						}
					}
					currString = newString;
				}

				output.add(list);
			}
		}
		return output;
	}

}
