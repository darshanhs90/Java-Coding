package Nov2020Leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _0347TopKFrequentElements {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3, 3, 3 }, 2)));
		System.out.println(Arrays.toString(topKFrequent(new int[] { 1 }, 1)));

	}

	public static int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.compute(nums[i], (key, v) -> v == null ? 1 : v + 1);
		}
		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		int[] output = new int[k];
		int index = 0;
		for (Map.Entry<Integer, Integer> entry : list) {
			if (index >= k)
				break;
			output[index] = entry.getKey();
			index++;
		}
		return output;
	}
}
