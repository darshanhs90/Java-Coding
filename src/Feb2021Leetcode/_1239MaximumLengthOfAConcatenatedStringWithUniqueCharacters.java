package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class _1239MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
	public static void main(String[] args) {
		System.out.println(maxLength(new ArrayList<String>(Arrays.asList("un", "iq", "ue"))));
		System.out.println(maxLength(new ArrayList<String>(Arrays.asList("cha", "r", "act", "ers"))));
		System.out.println(maxLength(new ArrayList<String>(Arrays.asList("abcdefghijklmnopqrstuvwxyz"))));
	}

	public static int maxLength(List<String> arr) {
		HashSet[] setArr = new HashSet[arr.size()];
		for (int i = 0; i < setArr.length; i++) {
			setArr[i] = new HashSet<Character>();
			String str = arr.get(i);
			for (int j = 0; j < str.length(); j++) {
				setArr[i].add(str.charAt(j));
			}
		}

		int maxLength = 0;
		int currLength = 0;
		for (int i = 0; i < setArr.length; i++) {
			currLength = arr.get(i).length();
			HashSet<Character> allChars = (HashSet<Character>) setArr[i].clone();
			for (int j = i + 1; j < setArr.length; j++) {
				if (!doesOverlap(allChars, setArr[j])) {
					currLength += arr.get(j).length();
					allChars.addAll(setArr[j]);
				}
			}
			maxLength = Math.max(currLength, maxLength);
		}
		return maxLength;
	}

	public static boolean doesOverlap(HashSet<Character> allChars, HashSet<Character> testChars) {
		Iterator<Character> iter = testChars.iterator();
		while (iter.hasNext()) {
			if (allChars.contains(iter.next()))
				return true;
		}
		return false;
	}

}
