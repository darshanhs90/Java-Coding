package April2021PrepLeetcode;

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
		HashSet<String> visited = new HashSet<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < strings.length; i++) {
			map.compute(strings[i], (k, v) -> v == null ? 1 : v + 1);
		}
		List<List<String>> output = new ArrayList<List<String>>();

		for (int i = 0; i < strings.length; i++) {
			String str = strings[i];
			if (!visited.contains(str)) {
				char[] cArr = str.toCharArray();
				List<String> list = new ArrayList<String>();

				for (int j = 0; j < 26; j++) {
					for (int k = 0; k < cArr.length; k++) {
						char c = cArr[k];
						int newCharIndex = c - 'a' + 1;
						if (newCharIndex >= 26)
							newCharIndex = 0;
						cArr[k] = (char) (newCharIndex + 'a');
					}

					String strNew = new String(cArr);
					if (map.containsKey(strNew)) {
						int count = map.get(strNew);
						for (int k = 0; k < count; k++) {
							list.add(strNew);
						}
						visited.add(strNew);
					}
				}

				output.add(list);
			}
		}
		return output;
	}

}
