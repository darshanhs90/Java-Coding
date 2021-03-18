package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0763PartitionLabels {
	public static void main(String[] args) {
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
		System.out.println(partitionLabels("abc"));
	}

	public static List<Integer> partitionLabels(String S) {
		HashMap<Character, Integer> lastIndexMap = new HashMap<Character, Integer>();
		for (int i = 0; i < S.length(); i++) {
			lastIndexMap.put(S.charAt(i), i);
		}

		List<Integer> output = new ArrayList<Integer>();
		int left = 0, right = 0;
		Integer currMax = null;
		while (right < S.length()) {
			int max = lastIndexMap.get(S.charAt(right));

			if (currMax == null) {
				currMax = max;
			} else {
				currMax = Math.max(max, currMax);
			}

			if (currMax == right) {
				output.add(right - left+1);
				left = right + 1;
				currMax = null;
			}
			right++;
		}
		return output;
	}
}
