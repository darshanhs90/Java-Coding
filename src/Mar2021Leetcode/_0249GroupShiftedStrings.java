package Mar2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class _0249GroupShiftedStrings {

	public static void main(String[] args) {
		System.out.println(groupStrings(new String[] { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" }));
		System.out.println(groupStrings(new String[] { "a", "a" }));
	}

	public static List<List<String>> groupStrings(String[] strings) {
		HashSet<String> set = new HashSet<String>(new ArrayList<String>(Arrays.asList(strings)));
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		for (int i = 0; i < strings.length; i++) {
			String str = strings[i];
			if (set.contains(str)) {
				map.put(str, new ArrayList<String>());

				char[] cArr = str.toCharArray();

				for (int count = 0; count < 26; count++) {
					for (int j = 0; j < cArr.length; j++) {
						cArr[j] += 1;
						if (cArr[j] > 'z')
							cArr[j] = 'a';
					}
					String newString = new String(cArr);
					if (set.contains(newString)) {
						set.remove(newString);
						map.get(str).add(newString);
					}
				}
			}
		}

		List<List<String>> output = new ArrayList<List<String>>();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			output.add(entry.getValue());
		}
		return output;
	}

}
