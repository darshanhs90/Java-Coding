package June2021GoogLeetcode;

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
		for (String str : strings) {
			map.compute(str, (k, v) -> v == null ? 1 : v + 1);
		}

		List<List<String>> output = new ArrayList<List<String>>();
		for (String str : strings) {
			if (map.containsKey(str) && map.get(str) > 0) {
				List<String> list = new ArrayList<String>();
				char[] cArr = str.toCharArray();

				for (int i = 0; i < 26; i++) {
					for (int j = 0; j < cArr.length; j++) {
						char c = cArr[j];
						if (c == 'z')
							c = 'a';
						else
							c += 1;

						cArr[j] = c;
					}
					str = new String(cArr);
					if (map.containsKey(str)) {
						int count = map.get(str);
						for (int j = 0; j < count; j++) {
							list.add(str);
						}
						map.remove(str);
					}
				}
				output.add(list);
			}
		}
		return output;
	}

}
