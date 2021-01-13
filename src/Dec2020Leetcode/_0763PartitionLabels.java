package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0763PartitionLabels {
	public static void main(String[] args) {
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
		System.out.println(partitionLabels("abc"));
	}

	public static List<Integer> partitionLabels(String S) {
		List<Integer> list = new ArrayList<Integer>();
		if (S == null || S.length() == 0)
			return list;

		HashMap<Character, Integer> endIndex = new HashMap<Character, Integer>();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			endIndex.put(c, i);
		}

		int currMax = S.charAt(0);
		int left = 0, right = 0;
		while (right < S.length()) {
			currMax = endIndex.get(S.charAt(right));
			while (right <= currMax) {
				currMax = Math.max(currMax, endIndex.get(S.charAt(right)));
				right++;
			}
			list.add(right - left);
			left = right;
		}

		return list;
	}
}
