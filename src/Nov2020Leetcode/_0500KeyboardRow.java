package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _0500KeyboardRow {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findWords(new String[] { "Hello", "Alaska", "Dad", "Peace" })));
		System.out.println(Arrays.toString(findWords(new String[] { "abdfs", "cccd", "a", "qwwewm" })));
	}

	public static String[] findWords(String[] words) {
		String row1 = "qwertyuiop";
		String row2 = "asdfghjkl";
		String row3 = "zxcvbnm";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < row1.length(); i++) {
			map.put(row1.charAt(i), 1);
		}
		for (int i = 0; i < row2.length(); i++) {
			map.put(row2.charAt(i), 2);
		}
		for (int i = 0; i < row3.length(); i++) {
			map.put(row3.charAt(i), 3);
		}
		List<String> out = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			boolean hasSameRowString = true;
			Integer rowVal = null;
			String word = words[i].toLowerCase();
			for (int j = 0; j < word.length(); j++) {
				char c = word.charAt(j);
				if (rowVal == null) {
					rowVal = map.get(c);
				} else if (rowVal != map.get(c)) {
					hasSameRowString = false;
					break;
				}
			}
			if (hasSameRowString) {
				out.add(words[i]);
			}
		}

		String[] outArr = new String[out.size()];
		for (int i = 0; i < outArr.length; i++) {
			outArr[i] = out.get(i);
		}
		return outArr;
	}
}
