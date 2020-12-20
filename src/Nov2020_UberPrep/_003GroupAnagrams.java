package Nov2020_UberPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _003GroupAnagrams {

	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
		System.out.println(groupAnagrams(new String[] { "" }));
		System.out.println(groupAnagrams(new String[] { "a" }));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> outputList = new ArrayList<List<String>>();
		HashMap<String, List<String>> stringMap = new HashMap<String, List<String>>();

		for (int i = 0; i < strs.length; i++) {
			String currString = strs[i];
			char[] cArr = currString.toCharArray();
			Arrays.sort(cArr);
			String transformedString = new String(cArr);
			if (stringMap.containsKey(transformedString)) {
				stringMap.get(transformedString).add(currString);
			} else {
				List<String> list = new ArrayList<String>(Arrays.asList(currString));
				stringMap.put(transformedString, list);
			}
		}

		for (Map.Entry<String, List<String>> entry : stringMap.entrySet()) {
			outputList.add(entry.getValue());
		}
		return outputList;
	}
}
