package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0500KeyboardRow {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findWords(new String[] { "Hello", "Alaska", "Dad", "Peace" })));
		System.out.println(Arrays.toString(findWords(new String[] { "abdfs", "cccd", "a", "qwwewm" })));
	}

	public static String[] findWords(String[] words) {
		HashMap<Integer, Set<Character>> map = new HashMap<Integer, Set<Character>>();
		map.put(1, new HashSet<Character>(
				new ArrayList<Character>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'))));
		map.put(2, new HashSet<Character>(
				new ArrayList<Character>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'))));
		map.put(3, new HashSet<Character>(new ArrayList<Character>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'))));

		List<String> outputList = new ArrayList<String>();
		for (String word : words) {
			String lowerWord = word.toLowerCase();
			boolean isValid = true;
			char c = lowerWord.charAt(0);
			int row = map.get(1).contains(c) ? 1 : map.get(2).contains(c) ? 2 : 3;
			for (int i = 1; i < lowerWord.length(); i++) {
				c = lowerWord.charAt(i);
				if (map.get(row).contains(c))
					continue;
				else
					isValid = false;
			}
			if (isValid)
				outputList.add(word);
		}

		String[] output = new String[outputList.size()];
		for (int i = 0; i < output.length; i++) {
			output[i] = outputList.get(i);
		}
		return output;
	}
}
