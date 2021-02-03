package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0763PartitionLabels {
	public static void main(String[] args) {
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
		System.out.println(partitionLabels("abc"));
	}

	public static List<Integer> partitionLabels(String s) {
		List<Integer> list = new ArrayList<Integer>();
		if (s == null || s.length() == 0)
			return list;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);
		}

		int currMax = -1;
		int left = 0;
		for (int i = 0; i < s.length(); i++) {
			currMax = Math.max(currMax, map.get(s.charAt(i)));
			if (i == currMax) {
				list.add(i - left + 1);
				left = i+1;
			}
		}
		return list;
	}
}
