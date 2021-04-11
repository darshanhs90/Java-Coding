package April2021Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class _0347TopKFrequentElements {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3, 3, 3 }, 2)));
		System.out.println(Arrays.toString(topKFrequent(new int[] { 1 }, 1)));
	}

	public static int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.compute(nums[i], (key, val) -> val == null ? 1 : val + 1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(k,
				new Comparator<Map.Entry<Integer, Integer>>() {

					@Override
					public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
						// TODO Auto-generated method stub
						return o2.getValue() - o1.getValue();
					}
				});

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			pq.offer(entry);
		}

		int[] out = new int[k];
		for (int i = 0; i < out.length; i++) {
			out[i] = pq.poll().getKey();
		}
		return out;
	}

}
