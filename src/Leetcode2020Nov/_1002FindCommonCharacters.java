package Leetcode2020Nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1002FindCommonCharacters {
	public static void main(String[] args) {
		System.out.println(commonChars(new String[] { "bella", "label", "roller" }));
		System.out.println(commonChars(new String[] { "cool", "lock", "cook" }));
	}

	public static List<String> commonChars(String[] A) {
		List<String> output = new ArrayList<String>();
		if (A == null || A.length == 0) {
			return output;
		}

		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < A.length; i++) {
			int[] charArr = new int[26];
			String baseWord = A[i];
			Arrays.fill(charArr, 0);
			for (int j = 0; j < baseWord.length(); j++) {
				charArr[baseWord.charAt(j) - 97]++;
			}
			list.add(charArr);
		}
		for (int i = 0; i < 26; i++) {
			int minVal = Integer.MAX_VALUE;
			for (int j = 0; j < list.size(); j++) {
				minVal = Math.min(minVal, list.get(j)[i]);
			}
			for (int j = 0; j < minVal; j++) {
				output.add("" + (char) (i + 97));
			}
		}
		return output;
	}
}
