package Dec2020Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class _0347TopKFrequentElements {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3, 3, 3 }, 2)));
		System.out.println(Arrays.toString(topKFrequent(new int[] { 1 }, 1)));
	}

	public static int[] topKFrequent(int[] nums, int k) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			map.compute(nums[i], (key, v) -> v == null ? 1 : v + 1);
		}

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return map.get(o1) - map.get(o2);
			}
		});

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			heap.add(entry.getKey());
			if (heap.size() > k)
				heap.poll();
		}

		int[] output = new int[k];
		for (int i = k - 1; i >= 0; --i) {
			output[i] = heap.poll();
		}
		return output;
	}

}
