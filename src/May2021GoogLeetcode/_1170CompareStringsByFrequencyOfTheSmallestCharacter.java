package May2021GoogLeetcode;

import java.util.Arrays;
import java.util.TreeMap;

public class _1170CompareStringsByFrequencyOfTheSmallestCharacter {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(numSmallerByFrequency(new String[] { "cbd" }, new String[] { "zaaaz" })));
		System.out.println(Arrays.toString(
				numSmallerByFrequency(new String[] { "bbb", "cc" }, new String[] { "a", "aa", "aaa", "aaaa" })));
	}

	public static int[] numSmallerByFrequency(String[] queries, String[] words) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (String str : words) {
			int fNum = getFNumber(str);
			map.compute(fNum, (k, v) -> v == null ? 1 : v + 1);
		}

		int[] out = new int[queries.length];
		for (int i = 0; i < out.length; i++) {
			int fQueryNum = getFNumber(queries[i]);
			Integer key = map.ceilingKey(fQueryNum + 1);
			int count = 0;
			while (key != null) {
				count += map.get(key);
				key += 1;
				key = map.ceilingKey(key);
			}
			out[i] = count;
		}
		return out;
	}

	public static int getFNumber(String word) {
		char[] cArr = word.toCharArray();
		Arrays.sort(cArr);
		int count = 1;
		char prev = cArr[0];
		for (int i = 1; i < cArr.length; i++) {
			if (cArr[i] == prev) {
				count++;
			} else {
				return count;
			}
		}
		return count;
	}

}
