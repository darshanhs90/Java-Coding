package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0249GroupShiftedStrings {

	public static void main(String[] args) {
		System.out.println(groupStrings(new String[] { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" }));
		System.out.println(groupStrings(new String[] { "a", "a" }));
	}

	public static List<List<String>> groupStrings(String[] strings) {
		List<List<String>> output = new ArrayList<List<String>>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		HashMap<String, Integer> stringMap = new HashMap<String, Integer>();
		for (int i = 0; i < strings.length; i++) {
			stringMap.compute(strings[i], (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < strings.length; i++) {
			String currString = strings[i];
			if (stringMap.containsKey(currString) && stringMap.get(currString) > 0) {
				stringMap.compute(strings[i], (k, v) -> v == null ? 0 : v - 1);
				map.put(currString, new ArrayList<String>(Arrays.asList(currString)));
				String copy = currString;
				char[] cArr = copy.toCharArray();
				for (int j = 0; j < 26; j++) {
					for (int k = 0; k < copy.length(); k++) {
						int newIndex = (cArr[k] - 'a' + 1) % 26;
						cArr[k] = (char) (newIndex + 'a');
					}
					String newString = new String(cArr);
					if (stringMap.containsKey(newString) && stringMap.get(newString) > 0) {
						stringMap.compute(newString, (k, v) -> v == null ? 0 : v - 1);
						map.get(currString).add(newString);
					}
				}
			}
		}

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			output.add(entry.getValue());
		}
		return output;
	}

}
