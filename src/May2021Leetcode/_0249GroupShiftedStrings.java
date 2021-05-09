package May2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
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
		List<List<String>> output = new ArrayList<List<String>>();
		for (String str : strings) {
			if (map.containsKey(str)) {
				char[] cArr = str.toCharArray();
				List<String> list = new ArrayList<String>();
				for (int i = 0; i < 26; i++) {
					for (int j = 0; j < cArr.length; j++) {
						cArr[j] += 1;
						if (cArr[j] > 'z')
							cArr[j] = 'a';
					}
					String newString = new String(cArr);
					if (map.containsKey(newString)) {
						int count = map.get(newString);
						for (int j = 0; j < count; j++) {
							list.add(newString);
						}
						map.remove(newString);
					}
				}
				output.add(list);
			}
		}
		return output;
	}

}
