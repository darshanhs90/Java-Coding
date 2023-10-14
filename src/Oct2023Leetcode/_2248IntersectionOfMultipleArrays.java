package Oct2023Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class _2248IntersectionOfMultipleArrays {
	public static void main(String[] args) {
		System.out.println(intersection(
				new int[][] { new int[] { 3, 1, 2, 4, 5 }, new int[] { 1, 2, 3, 4 }, new int[] { 3, 4, 5, 6 } }));
		System.out.println(intersection(new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 } }));
	}

	public static List<Integer> intersection(int[][] nums) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < nums[i].length; j++) {
				int currNum = nums[i][j];
				if (!set.contains(currNum)) {
					set.add(currNum);
					if (map.containsKey(currNum)) {
						map.put(currNum, map.get(currNum) + 1);
					} else {
						map.put(currNum, 1);
					}
				}
			}
		}
		ArrayList<Integer> output = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == nums.length) {
				output.add(entry.getKey());
			}
		}
		return output;
	}
}
