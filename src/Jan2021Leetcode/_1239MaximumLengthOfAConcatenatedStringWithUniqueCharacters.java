package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1239MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
	public static void main(String[] args) {
		System.out.println(maxLength(new ArrayList<String>(Arrays.asList("un", "iq", "ue"))));
		System.out.println(maxLength(new ArrayList<String>(Arrays.asList("cha", "r", "act", "ers"))));
		System.out.println(maxLength(new ArrayList<String>(Arrays.asList("abcdefghijklmnopqrstuvwxyz"))));
	}

	static int max;

	public static int maxLength(List<String> arr) {
		max = 0;
		dfs(0, "", arr);
		return max;
	}

	public static void dfs(int index, String currString, List<String> arr) {
		max = Math.max(currString.length(), max);

		for (int i = index; i < arr.size(); i++) {
			if (!overlaps(currString + arr.get(i))) {
				dfs(i + 1, currString + arr.get(i), arr);
			}
		}
	}

	public static boolean overlaps(String currString) {
		int[] arr = new int[26];
		for (int i = 0; i < currString.length(); i++) {
			arr[currString.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (arr[i] > 1)
				return true;
		}
		return false;
	}

}
